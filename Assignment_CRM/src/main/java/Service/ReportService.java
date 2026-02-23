package Service;


import javax.persistence.EntityManager;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getEmployeePerformance(Long employeeId) {
        try {
            String jpql = "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :empId";

            Long leadCount = em.createQuery(jpql, Long.class)
                    .setParameter("empId", employeeId)
                    .getSingleResult();

            System.out.println("Employee ID: " + employeeId);
            System.out.println("Total Leads Assigned: " + leadCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
