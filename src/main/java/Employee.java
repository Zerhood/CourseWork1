public class Employee {

    private static int counterId = 1;
    private int id;
    private String name;
    private int department;
    private int salary;

    public Employee(String name, int department, int salary) {
        id = counterId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            System.out.println("Please, choose from 1 to 5");
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee " +
                "id=" + id +
                ", name= " + name +
                ", department= " + department +
                ", salary= " + salary;
    }
}