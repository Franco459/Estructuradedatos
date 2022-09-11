package TP1;

import java.util.ArrayList;

public class LibroMod {

        private String title;
        private ArrayList<String> authors;
        private String editorial;
        private String yearOfRelease;
        private float price;
        private char literaryGenre;
        
        public LibroMod() {
        }
        public LibroMod(String title, ArrayList<String> authors, String editorial, String yearOfRelease, float price, char literaryGenre) {
            this.title = title;
            this.authors = authors;
            this.editorial = editorial;
            this.yearOfRelease = yearOfRelease;
            this.price = price;
            this.literaryGenre = literaryGenre;
        }

        @Override
        public String toString() {
            String genre = (getLiteraryGenre() == 'd')? "dramático" : (getLiteraryGenre() == 'l')? "lirico" : "narrativo";
            return "** Titulo de libro: " + title + " **\n[Autor/es: " + authors + ", editorial: " + editorial + ", año de lanzamiento: " + yearOfRelease + ", precio: " + price 
            + ", genero: " + genre +"]\n";
        }
        /***************/
        
        public String getTitle(){
            return this.title;
        }
        public void setTitle(String title){
            this.title = title;
        }
    
        
        public ArrayList<String> getAuthor(){
            return this.authors;
        }
        public void setAuthor(ArrayList<String> authors){
            this.authors = authors;
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

        
        public char getLiteraryGenre() {
            return literaryGenre;
        }
        public void setLiteraryGenre(char literaryGenre) {
            this.literaryGenre = literaryGenre;
        }
    }

