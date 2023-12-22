import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public void addEmployee(Employee emp) {
        for (Employee e : employees) {
            if (e == null) {
                employees[emp.getId()] = emp;
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getId() == id) {
//                    employees[e.getId()] = null;
//                }
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getId() == id)
                .forEach(e -> employees[e.getId()] = null);
    }

    public void deleteEmployee(String name) {
//        for (Employee e : employees) {
//            if (e != null) {
//                if (Objects.equals(e.getName(), name)) {
//                    employees[e.getId()] = null;
//                }
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getName().equals(name))
                .forEach(e -> employees[e.getId()] = null);
    }

    public void setEmployee(String name, int salary, int department) {
        for (Employee e : employees) {
            if (e != null) {
                if (Objects.equals(e.getName(), name)) {
                    if (salary > 0) {
                        e.setSalary(salary);
                    }
                    if (department > 0 && department <= 5) {
                        e.setDepartment(department);
                    }
                }
            }
        }
    }

    /**
     * метод сортирует сотрудников по департаменту и выводит их в порядке увеличения
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
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Employee::getDepartment))
                .forEach(s -> System.out.println(s.getDepartment() + " " + s.getName()));
    }

    public void getAllEmployee() {
//        for (Employee e : employees) {
//            if (e != null) {
//                System.out.println(e);
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    public void getSumSalariesPerMonth() {
//        int sum = 0;
//        for (Employee employee : employees) {
//            if (employee != null) {
//                sum += employee.getSalary();
//            }
//        }
//        System.out.println(sum);
        System.out.println(Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .sum());
    }

    public void getEmpMinSalaryInDepartment() {
//        int min = employees[0].getSalary();
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getSalary() < min) {
//                    min = e.getSalary();
//                }
//            }
//        }
//        System.out.println(min);
        System.out.println(Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .min());
    }

    public void getEmpMaxSalaryInDepartment() {
//        int max = employees[0].getSalary();
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getSalary() > max) {
//                    max = e.getSalary();
//                }
//            }
//        }
//        System.out.println(max);
        System.out.println(Arrays.stream(employees)
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
        System.out.println(Arrays.stream(employees)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .average());
    }

    public void getNameEmployees() {
//        for (Employee e : employees) {
//            if (e != null) {
//                System.out.println(e.getName());
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(s -> System.out.println(s.getName()));
    }

    /**
     * Повышенная сложность
     */
    public void setIndexingSalary(int percent) {
        double newPercent = (double) percent / 100 + 1;
//        for (Employee e : employees) {
//            if (e != null) {
//                e.setSalary((int) (e.getSalary() * newPercent));
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .forEach(e -> e.setSalary((int) (e.getSalary() * newPercent)));
    }

    public void getEmpMinSalaryInDepartment(int department) {
//        if (department > 0 && department < 6) {
//            int min = employees[0].getSalary();
//            for (Employee e : employees) {
//                if (e != null) {
//                    if (e.getDepartment() == department) {
//                        if (e.getSalary() < min) {
//                            min = e.getSalary();
//                        }
//                    }
//                }
//            }
//            System.out.println("Сотрудник " + department+ " отдела с минимальной зарплатой - " + min);
//        } else {
//            System.out.println("Error count department");
//        }
        System.out.println("Сотрудник " + department + " отдела с минимальной зарплатой - " +
                Arrays.stream(employees)
                        .filter(Objects::nonNull)
                        .filter(s -> s.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .min());
    }

    public void getEmpMaxSalaryInDepartment(int department) {
//        int max = employees[0].getSalary();
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getDepartment() == department) {
//                    if (e.getSalary() > max) {
//                        max = e.getSalary();
//                    }
//                }
//            }
//        }
//        System.out.println("Сотрудник " + department + " отдела с максимальной зарплатой - " + max);
        System.out.println("Сотрудник " + department + " отдела с максимальной зарплатой - " +
                Arrays.stream(employees)
                        .filter(Objects::nonNull)
                        .filter(s -> s.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .max());
    }

    public void getSumSalariesPerMonthInDepartment(int department) {
//        int sum = 0;
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getDepartment() == department) {
//                    sum += e.getSalary();
//                }
//            }
//        }
//        System.out.println(sum);
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
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getDepartment() == department) {
//                    e.setSalary((int) (e.getSalary() * newPercent));
//                }
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartment() == department)
                .forEach(e -> e.setSalary((int) (e.getSalary() * newPercent)));
    }

    public void getNameEmployeesInDepartment(int department) {
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getDepartment() == department) {
//                    System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
//                }
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getDepartment() == department)
                .forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
    }

    public void getAllEmpLessSpecNumber(int number) {
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getSalary() < number) {
//                    System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
//                }
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() < number)
                .forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
    }

    public void getAllEmpGreatSpecNumber(int number) {
//        for (Employee e : employees) {
//            if (e != null) {
//                if (e.getSalary() >= number) {
//                    System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
//                }
//            }
//        }
        Arrays.stream(employees)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() >= number)
                .forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));
    }
}