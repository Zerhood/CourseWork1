import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public void addEmployee(Employee emp) {
        Arrays.stream(employees)
                .map(employee -> employees[emp.getId()] = emp)
                .peek(employee -> System.out.println("Добавлен новый сотрудник - " + employees[emp.getId()].getName()))
                .findFirst();
    }

    public void deleteEmployee(int id) {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getId() == id)
                .peek(e -> System.out.println("Сотрудник - " + e.getName() + " удалён!"))
                .forEach(e -> employees[e.getId()] = null);
    }

    public void deleteEmployee(String name) {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getName().equals(name))
                .peek(e -> System.out.println("Сотрудник - " + e.getName() + " удалён!"))
                .forEach(e -> employees[e.getId()] = null);
    }

    public void setEmployee(String name, int salary, int department) {
        for (Employee e : employees) {
            if (e != null) {
                if (Objects.equals(e.getName(), name)) {
                    if (salary > 0 && department > 0 && department <= 5) {
                        e.setSalary(salary);
                        e.setDepartment(department);
                        System.out.println("Сотрудник - " + e.getName() + " изменён.");
                    } else {
                        System.out.println("Ошибка изменения данных!");
                    }
                } else {
                    System.out.println("Такой сотрудник не найдет!");
                    return;
                }
            }
        }
    }

    /**
     * метод группирует сотрудников по департаменту и выводит их в консоль
     */
    public void getAllEmpByDepartment() {
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null) {
//                for (Employee e : employees) {
//                    if (e != null) {
//                        if (e.getDepartment() == i) {
//                            System.out.println(e.getDepartment() + " " + e.getName());
//                        }
//                    }
//                }
//            }
//        }
        Map<Integer, List<String>> map = Arrays.stream(employees)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        map.forEach((k, v) -> System.out.println(k + "й отдел, сотрудники: " + v.toString().replaceAll("[]\\[]", "")));
    }

    public void getAllEmployee() {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    public void getSumSalariesPerMonth() {
        System.out.println("Сумма затрат на зарплату за месяц - " + Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .sum());
    }

    public void getEmpMinSalaryInDepartment() {
        System.out.println("Минимальная зарплата - " + Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .min());
    }

    public void getEmpMaxSalaryInDepartment() {
        System.out.println("Максимальная зарплата - " + Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .max());
    }

    public void getAverageSalary() {
//        int average;
//        int sum = 0;
//        int count = 0;
//        for (Employee e : employees) {
//            if (e != null) {
//                sum += e.getSalary();
//                count++;
//            }
//        }
//        average = sum / count;
//        System.out.println(average);
        System.out.println("Средняя зарплата - " + Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .average());
    }

    public void getNameEmployees() {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(s -> System.out.println(s.getName()));
    }

    public void setIndexingSalary(int percent) {
        double newPercent = (double) percent / 100 + 1;
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(e -> e.setSalary((int) (e.getSalary() * newPercent)));
    }

    public void getEmpMinSalaryInDepartment(int department) {
        System.out.println("Сотрудник " + department + " отдела с минимальной зарплатой - " +
                Arrays.stream(employees)
                        .filter(Objects::nonNull)
                        .filter(s -> s.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .min());
    }

    public void getEmpMaxSalaryInDepartment(int department) {
        System.out.println("Сотрудник " + department + " отдела с максимальной зарплатой - " +
                Arrays.stream(employees)
                        .filter(Objects::nonNull)
                        .filter(s -> s.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .max());
    }

    public void getSumSalariesPerMonthInDepartment(int department) {
        System.out.println("Сумма затрат на зарплату " + department + " отдела составила - " +
                Arrays.stream(employees)
                        .filter(Objects::nonNull)
                        .filter(s -> s.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .sum());
    }

    public void getAverageSalaryInDepartment(int department) {
//        int average;
//        int sum = 0;
//        int count = 0;
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getDepartment() == department) {
//                    sum += e.getSalary();
//                    count++;
//                }
//            }
//        }
//        average = sum / count;
//        System.out.println(average);
        System.out.println("Средняя зарплата по " + department + " отделу составила " +
                Arrays.stream(employees)
                        .filter(Objects::nonNull)
                        .filter(s -> s.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .average());
    }

    public void setIndexingSalaryInDepartment(int percent, int department) {
        double newPercent = (double) percent / 100 + 1;
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartment() == department)
                .forEach(e -> e.setSalary((int) (e.getSalary() * newPercent)));
    }

    public void getNameEmployeesInDepartment(int department) {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartment() == department)
                .forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
    }

    public void getAllEmpLessSpecNumber(int number) {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() < number)
                .forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
    }

    public void getAllEmpGreatSpecNumber(int number) {
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() >= number)
                .forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
    }
}