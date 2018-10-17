package com.mcia.inventory.backend.config;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Configuration
class InitialPopulator {

    private Random rand = new Random();
    private List<String> otherDevicesTypes = Arrays.asList("HDD", "SSD", "Font");
    private List<String> monitorInput = Arrays.asList("VGA", "HDMI");

    @Bean
    CommandLineRunner initDatabase(ComputerRepository computerRepository,
                                   EmployeeRepository employeeRepository,
                                   LicenseRepository licenseRepository,
                                   LocationRepository locationRepository,
                                   MonitorRepository monitorRepository,
                                   OtherDeviceRepository otherDeviceRepository,
                                   PrinterRepository printerRepository,
                                   ProjectRepository projectRepository,
                                   SupplierRepository supplierRepository) {


        return args -> {
            List<Supplier> suppliers = supplierRepository.saveAll(Arrays.asList(
                    new Supplier(null, "Autodesk", "97281234", "G45601267", "mail@autodesk.com"),
                    new Supplier(null, "Microsoft", "937124614", "B23378456", "mail@microsoft.com"),
                    new Supplier(null, "Keil", "937384598", "F12309245", "mail@keil.com")));
            log.info("Created {} suppliers", supplierRepository.count());

            List<Location> locations = locationRepository.saveAll(Arrays.asList(
                    new Location(null, "TR14", "1", "121", "01-05-14"),
                    new Location(null, "TR14", "1", "120", "02-06-13"),
                    new Location(null, "TR14", "2", "3.6", "03-01-18")));
            log.info("Created {} locations", locationRepository.count());

            for (int i = 0; i < 30; i++) {
                licenseRepository.saveAll(Arrays.asList(
                        new License(null, "windows", "ofimatica", "VL", "no", randomDate(), randomDate(), "anual", suppliers.get(2)),
                        new License(null, "IntelliJ", "IDE", "single", "no", randomDate(), randomDate(), "anual", randEnt(suppliers))));
            }
            List<License> licenses = licenseRepository.findAll();
            log.info("Created {} licenses", licenseRepository.count());

            List<Employee> employees = employeeRepository.saveAll(Arrays.asList(
                    new Employee(null, "Victor Martínez", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Enric Sala", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Luis Romeral", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Carles Colls", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Isaac Newton", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Johannes Kepler", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Von Braun", "", "", randomDate(), randomDate(), "")));
            log.info("Created {} employees", employeeRepository.count());

            List<Project> projects = projectRepository.saveAll(Arrays.asList(
                    new Project(null, "ECOBULK", "ECO", randomDate(), randomDate(), randEnt(employees),
                            Arrays.asList(randEnt(licenses), randEnt(licenses)), Arrays.asList(employees.get(0))),
                    new Project(null, "MOSCOSINUS", "MOSC", randomDate(), randomDate(), randEnt(employees),
                            Arrays.asList(randEnt(licenses), randEnt(licenses)), Arrays.asList(employees.get(3)))));
            log.info("Created {} projects", projectRepository.count());

            for (int i = 0; i < 20; i++) {
                otherDeviceRepository.save(
                        new OtherDevice(null, "samsung", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), randEnt(otherDevicesTypes), "01-05-14", randEnt(employees)));
            }
            log.info("Created {} other Devices", otherDeviceRepository.count());

            List<Printer> printers = printerRepository.saveAll(Arrays.asList(
                    new Printer(null, "samsung", randomCode(6), randomCode(8), randEnt(locations),
                            randomDate(), "202", "101", "01-12-10", randEnt(employees)),
                    new Printer(null, "epson", randomCode(6), randomCode(8), randEnt(locations),
                            randomDate(), "e-302", "101", "02-11-40", randEnt(employees)),
                    new Printer(null, "hp", randomCode(6), randomCode(8), randEnt(locations),
                            randomDate(), "hp210", "hprgb21", "01-32-05", randEnt(employees))));
            log.info("Created {} other printers", printerRepository.count());

            for (int i = 0; i < 40; i++) {
                monitorRepository.save(
                        new Monitor(null, "samsung", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "1920x1080", randEnt(monitorInput),
                                randomAmount(), randomDate(), true, Arrays.asList(randEnt(employees), randEnt(employees))));
                monitorRepository.save(
                        new Monitor(null, "benq", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "720x480", randEnt(monitorInput),
                                randomAmount(), randomDate(), true, Arrays.asList(randEnt(employees), randEnt(employees))));
                monitorRepository.save(
                        new Monitor(null, "LG", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "1920x1080", randEnt(monitorInput),
                                randomAmount(), randomDate(), true, Arrays.asList(randEnt(employees), randEnt(employees))));
            }
            List<Monitor> monitors = monitorRepository.findAll();
            log.info("Created {} monitors", monitorRepository.count());

            for (int i = 0; i < 30; i++) {
                computerRepository.save(
                        new Computer(null, "samsung", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "i7-6700", "kingston 8gb", "gtx-1000", "1tb",
                                randomAmount(), randomDate(), "01-06-15", "", true,
                                Arrays.asList(monitors.get(i * 4), monitors.get(i * 4 + 1)),
                                Arrays.asList(randEnt(employees), randEnt(employees)),
                                Arrays.asList(randEnt(licenses), randEnt(licenses))));
                computerRepository.save(
                        new Computer(null, "hp", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "i5-75000", "kingston 8gb", "radeon M500", "500tb samsung",
                                randomAmount(), randomDate(), "01-20-11", "", false,
                                Arrays.asList(monitors.get(i * 4 + 2), monitors.get(i * 4 + 3)),
                                Arrays.asList(randEnt(employees), randEnt(employees)),
                                Arrays.asList(randEnt(licenses), randEnt(licenses))));
            }
            log.info("Created {} computers", computerRepository.count());
        };
    }

    private Date randomDate() {
        long limit = 90 * 24 * 60 * 60 * 1000L;
        long shift = new Double(limit * (rand.nextDouble() - .5)).longValue();
        return new Date(System.currentTimeMillis() - shift);
    }

    private String randomCode(int length) {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(uuid.length()-length);
    }

    private BigDecimal randomAmount() {
        double amount = rand.nextDouble() * 1e3;
        return new BigDecimal(amount);
    }

    private <E> E randEnt(List<E> list) {
        return list.get(rand.nextInt(list.size()));
    }
}