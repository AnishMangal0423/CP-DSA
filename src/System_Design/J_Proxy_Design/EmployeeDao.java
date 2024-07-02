package System_Design.J_Proxy_Design;

public interface EmployeeDao {

    // So Basically it is the Dao Layer what i Want is , ki koi bhi aakar ise Access Nhi Kr Payee..

//    public void create(String role, Employee e)throws Exception;
    public void delete(String role, int employeeId)throws Exception;
//    public Employee get(String role, int employeeId)throws Exception;
}
