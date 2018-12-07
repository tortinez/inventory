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

    private final Random rand = new Random();
    private final List<String> monitorInput = Arrays.asList("VGA", "HDMI");

    @Bean
    CommandLineRunner initDatabase(ComputerRepository computerRepository,
                                   EmployeeRepository employeeRepository,
                                   LicenseRepository licenseRepository,
                                   LocationRepository locationRepository,
                                   MonitorRepository monitorRepository,
                                   NetworkSocketRepository networkSocketRepository,
                                   OtherDeviceRepository otherDeviceRepository,
                                   OtherDeviceTypeRepository otherDeviceTypeRepository,
                                   PrinterRepository printerRepository,
                                   ProjectRepository projectRepository,
                                   SupplierRepository supplierRepository) {


        return args -> {
            List<OtherDeviceType> otherDevicesTypes = new ArrayList<>();
            otherDeviceTypeRepository.saveAll(Arrays.asList(
                    new OtherDeviceType(null, "HDD"),
                    new OtherDeviceType(null, "SSD"),
                    new OtherDeviceType(null, "Font d'alimentació"))).forEach(otherDevicesTypes::add);
            log.info("Created {} other device types", otherDeviceTypeRepository.count());

            List<NetworkSocket> networkSockets = new ArrayList<>();
            networkSocketRepository.saveAll(Arrays.asList(
                    new NetworkSocket(null, "01-05-15"),
                    new NetworkSocket(null, "01-05-16"),
                    new NetworkSocket(null, "01-06-18"),
                    new NetworkSocket(null, "02-06-19"),
                    new NetworkSocket(null, "02-07-21"),
                    new NetworkSocket(null, "02-07-22"),
                    new NetworkSocket(null, "03-08-24"),
                    new NetworkSocket(null, "03-08-25"),
                    new NetworkSocket(null, "03-01-27"),
                    new NetworkSocket(null, "04-01-28"),
                    new NetworkSocket(null, "04-02-30"),
                    new NetworkSocket(null, "04-02-31"),
                    new NetworkSocket(null, "05-03-33"),
                    new NetworkSocket(null, "05-08-24"),
                    new NetworkSocket(null, "05-08-25"),
                    new NetworkSocket(null, "06-01-27"),
                    new NetworkSocket(null, "06-01-28"),
                    new NetworkSocket(null, "06-02-30"),
                    new NetworkSocket(null, "07-02-31"),
                    new NetworkSocket(null, "07-03-33"))).forEach(networkSockets::add);
            log.info("Created {} network sockets", networkSocketRepository.count());


            List<Supplier> suppliers = new ArrayList<>();
            supplierRepository.saveAll(Arrays.asList(
                    new Supplier(null, "Autodesk", "97281234", "G45601267", "mail@autodesk.com"),
                    new Supplier(null, "Microsoft", "937124614", "B23378456", "mail@microsoft.com"),
                    new Supplier(null, "Keil", "937384598", "F12309245", "mail@keil.com"))).forEach(suppliers::add);
            log.info("Created {} suppliers", supplierRepository.count());

            List<Location> locations = new ArrayList<>();
            locationRepository.saveAll(Arrays.asList(
                    new Location(null, "TR14", "1", "121", Arrays.asList(randEnt(networkSockets))),
                    new Location(null, "TR14", "1", "120", Arrays.asList(randEnt(networkSockets))),
                    new Location(null, "TR14", "2", "3.6", Arrays.asList(randEnt(networkSockets))))).forEach(locations::add);
            log.info("Created {} locations", locationRepository.count());


            List<Employee> employees = new ArrayList<>();
            employeeRepository.saveAll(Arrays.asList(
                    new Employee(null, "Victor Martínez", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Enric Sala", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Luis Romeral", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Carles Colls", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Isaac Newton", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Johannes Kepler", "", "", randomDate(), randomDate(), ""),
                    new Employee(null, "Von Braun", "", "", randomDate(), randomDate(), ""))).forEach(employees::add);
            log.info("Created {} employees", employeeRepository.count());

            List<Project> projects = new ArrayList<>();
            projectRepository.saveAll(Arrays.asList(
                    new Project(null, "ECOBULK", "ECO", randomDate(), randomDate(), randEnt(employees), Arrays.asList(randEnt(employees))),
                    new Project(null, "MOSCOSINUS", "MOSC", randomDate(), randomDate(), randEnt(employees), Arrays.asList(randEnt(employees))))).forEach(projects::add);
            log.info("Created {} projects", projectRepository.count());

            for (int i = 0; i < 20; i++) {
                otherDeviceRepository.save(
                        new OtherDevice(null, "samsung", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), randEnt(otherDevicesTypes), Arrays.asList(randEnt(networkSockets)), randEnt(employees)));
            }
            log.info("Created {} other Devices", otherDeviceRepository.count());

            printerRepository.saveAll(Arrays.asList(
                    new Printer(null, "samsung", randomCode(6), randomCode(8), randEnt(locations),
                            randomDate(), "202", "101", Arrays.asList(randEnt(networkSockets)), randEnt(employees)),
                    new Printer(null, "epson", randomCode(6), randomCode(8), randEnt(locations),
                            randomDate(), "e-302", "101", Arrays.asList(randEnt(networkSockets)), randEnt(employees)),
                    new Printer(null, "hp", randomCode(6), randomCode(8), randEnt(locations),
                            randomDate(), "hp210", "hprgb21", Arrays.asList(randEnt(networkSockets)), randEnt(employees))));
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
            List<Monitor> monitors = new ArrayList<>();
            monitorRepository.findAll().forEach(monitors::add);
            log.info("Created {} monitors", monitorRepository.count());

            for (int i = 0; i < 30; i++) {
                computerRepository.save(
                        new Computer(null, "samsung", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "i7-6700", "kingston 8gb", "gtx-1000",
                                "gtx-940", "500gb", "1tb", "200mb", randomAmount(), randomDate(),
                                "", true, Arrays.asList(randEnt(networkSockets)),
                                Arrays.asList(monitors.get(i * 4), monitors.get(i * 4 + 1)),
                                Arrays.asList(randEnt(employees), randEnt(employees))));
                computerRepository.save(
                        new Computer(null, "hp", randomCode(6), randomCode(8),
                                randEnt(locations), randomDate(), "i5-75000", "kingston 8gb", "radeon M500",
                                "gtx-1050", "500tb samsung", "500gb", "1tb", randomAmount(), randomDate(),
                                "", false, Arrays.asList(randEnt(networkSockets)),
                                Arrays.asList(monitors.get(i * 4 + 2), monitors.get(i * 4 + 3)),
                                Arrays.asList(randEnt(employees), randEnt(employees))));
            }
            List<Computer> computers = new ArrayList<>();
            computerRepository.findAll().forEach(computers::add);
            log.info("Created {} computers", computerRepository.count());

            for (int i = 0; i < 30; i++) {
                licenseRepository.saveAll(Arrays.asList(
                        new License(null, "windows", "ofimatica", "VL", true, randomDate(),
                                randomDate(), "anual", suppliers.get(2),
                                Arrays.asList(randEnt(computers), randEnt(computers)),
                                Arrays.asList(randEnt(employees), randEnt(employees)), randEnt(projects)),
                        new License(null, "IntelliJ", "IDE", "single", false, randomDate(),
                                randomDate(), "anual", suppliers.get(2),
                                Arrays.asList(randEnt(computers), randEnt(computers)),
                                Arrays.asList(randEnt(employees), randEnt(employees)), randEnt(projects))));
            }
            List<License> licenses = new ArrayList<>();
            licenseRepository.findAll().forEach(licenses::add);
            log.info("Created {} licenses", licenseRepository.count());
        };
    }

    private Date randomDate() {
        long limit = 90 * 24 * 60 * 60 * 1000L;
        long shift = new Double(limit * (rand.nextDouble() - .5)).longValue();
        return new Date(System.currentTimeMillis() - shift);
    }

    private String randomCode(int length) {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(uuid.length() - length);
    }

    private BigDecimal randomAmount() {
        double amount = rand.nextDouble() * 1e3;
        return new BigDecimal(amount);
    }

    private <E> E randEnt(List<E> list) {
        return list.get(rand.nextInt(list.size()));
    }
}