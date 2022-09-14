package TP1;

public class Libro {
    private String title;
    private String author;
    private String editorial;
    private String yearOfRelease;
    private float price;
    
    public Libro(){

    }

    public Libro(String title, String author, String editorial, String yearOfRelease, float price){
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.yearOfRelease = yearOfRelease;
        this.price = price;
    }
    @Override
    public String toString() {
        return "** Titulo de libro: "+title+"\n[Autor: "+ author+", editorial: "+editorial+", año de lanzamiento: "+ yearOfRelease+", precio: "+ String.format("%.2f", price)+"]\n";
    }
    /***************/
    
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String author){
        this.author = author;
    }


    public String getEditorial(){
        return this.editorial;
    }
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }


    public String getYearOfRelease(){
        return this.yearOfRelease;
    }
    public void setYearOfRelease(String yearOfRelease){
        this.yearOfRelease = yearOfRelease;
    }
    

    public float getPrice(){
        return this.price;
    }
    public void setPrice(float price){
        this.price = price;
    }
    
}
