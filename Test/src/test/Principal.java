package test;


public class Principal {
    public Principal() {
        super();
    }    
        public static void main(String[] args) throws Exception {
            MySQLAccess dao = new MySQLAccess();
            WriteToFile writerHTML = new WriteToFile();
            String resultRows=dao.readDataBase();
            writerHTML.save(resultRows);
            FillTemplate1 reportBuilder=new FillTemplate1();
            reportBuilder.runTemplate();            
        }    
}
