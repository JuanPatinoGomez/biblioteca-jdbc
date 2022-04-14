package com.example.bibliotecajdbcrest.model;

import java.util.List;

public class LibroForm {
    
    private int id;
    private String titulo;
    private int anhoEdicion;
    private String ISBN;
    private int numeroPaginas;
    private String linkImagen;
    private String descripcion;

    private int idAutor;
    private List<Integer> listadoGeneros;


    
    public LibroForm() {
    }


    public LibroForm(int id, String titulo, int anhoEdicion, String iSBN, int numeroPaginas, String linkImagen,
            String descripcion, int idAutor, List<Integer> listadoGeneros) {
        this.id = id;
        this.titulo = titulo;
        this.anhoEdicion = anhoEdicion;
        ISBN = iSBN;
        this.numeroPaginas = numeroPaginas;
        this.linkImagen = linkImagen;
        this.descripcion = descripcion;
        this.idAutor = idAutor;
        this.listadoGeneros = listadoGeneros;
    }

    
    
    public LibroForm(int id, String titulo, int anhoEdicion, String iSBN, int numeroPaginas, String linkImagen,
            String descripcion) {
        this.id = id;
        this.titulo = titulo;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getIdAutor() {
        return idAutor;
    }
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    public List<Integer> getListadoGeneros() {
        return listadoGeneros;
    }
    public void setListadoGeneros(List<Integer> listadoGeneros) {
        this.listadoGeneros = listadoGeneros;
    }


    @Override
    public String toString() {
        return "LibroForm [ISBN=" + ISBN + ", anhoEdicion=" + anhoEdicion + ", descripcion=" + descripcion + ", id="
                + id + ", idAutor=" + idAutor + ", linkImagen=" + linkImagen + ", listadoGeneros=" + listadoGeneros
                + ", numeroPaginas=" + numeroPaginas + ", titulo=" + titulo + "]";
    }


    


    
}
