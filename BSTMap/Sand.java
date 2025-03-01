package BSTMap;

public class Sand {
    public static void main(String[] args) {
        BSTMap<String, BSTMap<String, Integer>> tree = new BSTMap<String,BSTMap<String,Integer>>();
        //Math
        BSTMap<String, Integer> students = new BSTMap<String,Integer>();
        students.put("Fabio", 20);
        students.put("Fabio", 18);
        
        students.put("Cisa", 21);
        students.put("Cisa", 12);
    
        students.put("Sam", 10);
        students.put("Sam", 12);
    
        tree.put("Math", students);
        System.out.println("Finished Math tree");
        
        students = new BSTMap<String,Integer>();
        students.put("Fabio", 20);
        students.put("Fabio", 18);
    
        students.put("Cisa", 21);
        students.put("Cisa", 12);
    
        students.put("Sam", 10);
        students.put("Sam", 12);
    
        tree.put("English", students);

        students = new BSTMap<String,Integer>();
        students.put("Fabio", 20);
        students.put("Fabio", 18);
    
        students.put("Cisa", 21);
        students.put("Cisa", 12);
        
        students.put("Sam", 10);
        students.put("Sam", 12);
        
        tree.put("Science", students);

        System.out.println(tree.toString());

    }
}
