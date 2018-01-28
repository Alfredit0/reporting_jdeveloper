package test;


public class Principal {
    public Principal() {
        super();
    }    
        public static void main(String[] args) throws Exception {
            MySQLAccess dao = new MySQLAccess();
            dao.readDataBase();
        }    
}
