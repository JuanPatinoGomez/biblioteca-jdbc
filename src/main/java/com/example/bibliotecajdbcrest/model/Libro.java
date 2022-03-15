package com.example.bibliotecajdbcrest.model;

public class Libro {

    private int id;
    private String titulo;
    private int idAutor;
    private int anhoEdicion;
    private String ISBN;
    private int numeroPaginas;
    private String linkImagen;
    private String descripcion;


    private Autor autor;
    private Genero genero;

    
    public Libro() {
    }


    public Libro(int id, String titulo, int idAutor, int anhoEdicion, String iSBN, int numeroPaginas,
            String linkImagen, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.anhoEdicion = anhoEdicion;
        this.ISBN = iSBN;
        this.numeroPaginas = numeroPaginas;
        this.linkImagen = linkImagen;
        this.descripcion = descripcion;
    }


    public Libro(String titulo, int idAutor, int anhoEdicion, String iSBN, int numeroPaginas,
            String linkImagen, String descripcion) {
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.anhoEdicion = anhoEdicion;
        ISBN = iSBN;
        this.numeroPaginas = numeroPaginas;
        this.linkImagen = linkImagen;
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getIdAutor() {
        return idAutor;
    }


    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }


    public int getAnhoEdicion() {
        return anhoEdicion;
    }


    public void setAnhoEdicion(int anhoEdicion) {
        this.anhoEdicion = anhoEdicion;
    }


    public String getISBN() {
        return ISBN;
    }


    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }


    public int getNumeroPaginas() {
        return numeroPaginas;
    }


    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }


    public String getLinkImagen() {
        return linkImagen;
    }


    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    

    public Autor getAutor() {
        return autor;
    }


    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    public Genero getGenero() {
        return genero;
    }


    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Libro [ISBN=" + ISBN + ", anhoEdicion=" + anhoEdicion + ", autor=" + autor + ", categoria=" + genero
                + ", id=" + id + ", idAutor=" + idAutor +  ", linkImagen=" + linkImagen
                + ", numeroPaginas=" + numeroPaginas + ", titulo=" + titulo + "]";
    }
   
    
    
}
