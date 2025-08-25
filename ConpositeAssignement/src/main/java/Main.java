import java.util.*;

/**
 * Assignment: Organization Structure using the Composite design pattern
 *
 * Single-file implementation for easy compiling and running:
 *   javac CompositeOrganization.java && java Main
 */

// === Component ===
interface OrgComponent {
    String getName();
    double getTotalSalary();

    // Uniform add/remove operations (leafs will throw UnsupportedOperationException)
    default void add(OrgComponent c) { throw new UnsupportedOperationException("Cannot add to leaf"); }
    default void remove(OrgComponent c) { throw new UnsupportedOperationException("Cannot remove from leaf"); }

    // XML serialization with indentation
    String toXml(int indent);
}

// === Leaf ===
class Employee implements OrgComponent {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = Objects.requireNonNull(name);
        this.salary = salary;
    }

    @Override
    public String getName() { return name; }

    public double getSalary() { return salary; }

    @Override
    public double getTotalSalary() { return salary; }

    @Override
    public String toXml(int indent) {
        String spaces = " ".repeat(indent);
        // Using attributes for compactness
        return String.format("%s<employee name=\"%s\" salary=\"%.2f\"/>\n", spaces, escape(name), salary);
    }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}

// === Composite ===
class Department implements OrgComponent {
    private final String name;
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) { this.name = Objects.requireNonNull(name); }

    @Override
    public String getName() { return name; }

    @Override
    public double getTotalSalary() {
        double sum = 0.0;
        for (OrgComponent c : children) sum += c.getTotalSalary();
        return sum;
    }

    @Override
    public void add(OrgComponent c) { children.add(Objects.requireNonNull(c)); }

    @Override
    public void remove(OrgComponent c) { children.remove(c); }

    public List<OrgComponent> getChildren() { return Collections.unmodifiableList(children); }

    @Override
    public String toXml(int indent) {
        String spaces = " ".repeat(indent);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s<department name=\"%s\">\n", spaces, escape(name)));
        for (OrgComponent c : children) {
            sb.append(c.toXml(indent + 2));
        }
        sb.append(String.format("%s</department>\n", spaces));
        return sb.toString();
    }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}

// === Root aggregate for convenience (not strictly required by Composite, but handy) ===
class Organization {
    private final Department root;

    public Organization(String name) { this.root = new Department(name); }

    public Department getRoot() { return root; }

    // Convenience, single-call helpers to satisfy the assignment wording
    public Department addDepartment(Department parent, String name) {
        Department d = new Department(name);
        parent.add(d);
        return d;
    }

    public Employee addEmployee(Department parent, String name, double salary) {
        Employee e = new Employee(name, salary);
        parent.add(e);
        return e;
    }

    public void remove(Department parent, OrgComponent child) { parent.remove(child); }

    public double totalSalary() { return root.getTotalSalary(); }

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<organization name=\"%s\">\n", escape(root.getName())));
        for (OrgComponent c : root.getChildren()) {
            sb.append(c.toXml(2));
        }
        sb.append("</organization>\n");
        return sb.toString();
    }

    public void printTotalSalary() { System.out.printf("Total salary: %.2f\n", totalSalary()); }
    public void printXml() { System.out.print(toXml()); }

    private static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}

// === Demo ===
public class Main {
    public static void main(String[] args) {
        // Build an example organization
        Organization org = new Organization("Acme Corp");
        Department root = org.getRoot();

        Department engineering = org.addDepartment(root, "Engineering");
        Department hr = org.addDepartment(root, "Human Resources");
        Department platform = org.addDepartment(engineering, "Platform");
        Department apps = org.addDepartment(engineering, "Applications");

        org.addEmployee(hr, "Alice HR", 52000);
        org.addEmployee(hr, "Bob HR", 56000);

        org.addEmployee(platform, "Charlie DevOps", 88000);
        org.addEmployee(platform, "Diana SRE", 94000);

        org.addEmployee(apps, "Eve Android", 90000);
        org.addEmployee(apps, "Frank iOS", 91000);

        // Print total salary (single call)
        org.printTotalSalary();

        // Print XML of the full hierarchy (single call)
        org.printXml();

        // Show add/remove at any time with single calls
        Employee contractor = org.addEmployee(platform, "Grace Contractor", 40000);
        org.printTotalSalary();

        org.remove(platform, contractor); // remove in one call
        org.printTotalSalary();

        // Print XML again after changes
        org.printXml();
    }
}
