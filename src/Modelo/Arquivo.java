/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import javax.swing.JOptionPane;

/**
 *
 * @author joaovitor
 */
public class Arquivo {
    
    //variaveis diretórios
    String home_diretorio = System.getProperty("user.home");
    String nome_usuario = System.getProperty("user.name");
    String path = home_diretorio+"/hicolm/"+"/"+nome_usuario+"/";
    //variaveis estrutura
    private String nome, quantidade_de_moleculas, atompmolec;
    private double tam_x, tam_y, tam_z;
    private int reuse;
    //variaveis md
    private String nhist,preext,text,ntrialmax,timestep, es1,es2,es3,rc1,rc2;
    private int nrelax;


    public Arquivo(double tam_x, double tam_y, double tam_z, String nome, String quantidade_de_moleculas, String atompmolec, int reuse,
            String nhist, String preext, String text, String ntrialmax,int nrelax ,String timestep, String es1, String es2, String es3, String rc1,String rc2) {
        this.tam_x = tam_x;
        this.tam_y = tam_y;
        this.tam_z = tam_z;
        this.nome = nome;
        this.quantidade_de_moleculas = quantidade_de_moleculas;
        this.atompmolec = atompmolec;
        this.reuse = reuse;
        this.nhist = nhist;
        this.preext = preext;
        this.text = text;
        this.ntrialmax = ntrialmax;
        this.nrelax = nrelax;
        this.timestep = timestep;
        this.es1 = es1;
        this.es2 = es2;
        this.es3 = es3;
        this.rc1 = rc1;
        this.rc2 = rc2;
    }

    public String getNhist() {
        return nhist;
    }

    public void setNhist(String nhist) {
        this.nhist = nhist;
    }

    public String getPreext() {
        return preext;
    }

    public void setPreext(String preext) {
        this.preext = preext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNtrialmax() {
        return ntrialmax;
    }

    public void setNtrialmax(String ntrialmax) {
        this.ntrialmax = ntrialmax;
    }

    public String getTimestep() {
        return timestep;
    }

    public void setTimestep(String timestep) {
        this.timestep = timestep;
    }

    public String getEs1() {
        return es1;
    }

    public void setEs1(String es1) {
        this.es1 = es1;
    }

    public String getEs2() {
        return es2;
    }

    public void setEs2(String es2) {
        this.es2 = es2;
    }

    public String getEs3() {
        return es3;
    }

    public void setEs3(String es3) {
        this.es3 = es3;
    }

    public String getRc1() {
        return rc1;
    }

    public void setRc1(String rc1) {
        this.rc1 = rc1;
    }

    public String getRc2() {
        return rc2;
    }

    public void setRc2(String rc2) {
        this.rc2 = rc2;
    }

    public int getNrelax() {
        return nrelax;
    }

    public void setNrelax(int nrelax) {
        this.nrelax = nrelax;
    }

    public int getReuse() {
        return reuse;
    }

    public void setReuse(int reuse) {
        this.reuse = reuse;
    }

    public String getAtompmolec() {
        return atompmolec;
    }

    public void setAtompmolec(String atompmolec) {
        this.atompmolec = atompmolec;
    }

    public String getQuantidade_de_moleculas() {
        return quantidade_de_moleculas;
    }

    public void setQuantidade_de_moleculas(String quantidade_de_moleculas) {
        this.quantidade_de_moleculas = quantidade_de_moleculas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTam_x() {
        return tam_x;
    }

    public void setTam_x(double tam_x) {
        this.tam_x = tam_x;
    }

    public double getTam_y() {
        return tam_y;
    }

    public void setTam_y(double tam_y) {
        this.tam_y = tam_y;
    }

    public double getTam_z() {
        return tam_z;
    }

    public void setTam_z(double tam_z) {
        this.tam_z = tam_z;
    }
    public void criarImput(){
        File diretorio = new File(this.path+"Project "+this.getNome());
        diretorio.mkdir();
        if(diretorio.exists()==false){
            JOptionPane.showMessageDialog(null, "Error creating directory", "Warning",  JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                PrintWriter arquivo_entrada = new PrintWriter(this.path+"Project "+this.getNome()+"/HICOLM.in");
                arquivo_entrada.println("# Structure variables\n\n&STRUCT\ncell");
                if(this.getTam_x() >= 10){
                    arquivo_entrada.println(this.getTam_x()+" 0.0  "+"0.0");
                }
                if(this.getTam_x()< 10){
                    arquivo_entrada.println(this.getTam_x()+"  0.0  "+"0.0");
                }
                if(this.getTam_y() >= 10){
                    arquivo_entrada.println("0.0 "+this.getTam_y()+"  0.0");
                }
                if(this.getTam_y() < 10){
                    arquivo_entrada.println("0.0  "+this.getTam_y()+"  0.0");
                }
                if(this.getTam_z() >= 10){
                    arquivo_entrada.println("0.0  0.0 "+this.getTam_z());
                }
                if(this.tam_z < 10){
                    arquivo_entrada.println("0.0  0.0  "+this.getTam_z());
                }
                arquivo_entrada.println("molecs 1");//rever para mais moléculas
                arquivo_entrada.println(this.getNome()+" "+this.getQuantidade_de_moleculas()+" "+this.getAtompmolec()+"\nreuse "+this.getReuse()+"\n&END\n");
                arquivo_entrada.println("# Molecular dynamics variables\n");
                arquivo_entrada.println("&MD\nnhist "+this.getNhist()+"\n"
                        + "preext "+this.getPreext()+"\n"
                        + "text "+this.getText()+"\n"
                        + "ntrialmax "+this.getNtrialmax()+"\n"
                        + "nrelax "+this.getNrelax()+"\n"
                        + "timestep "+this.getTimestep()+"\n"
                        + "ensemble npt berendsen "+this.getEs1()+" "+this.getEs2()+" "+this.getEs3()+"\n"
                        + "rcutoff "+this.getRc1()+" "+this.getRc2()+"\n"
                        + "&END\n");
                arquivo_entrada.println("# Force field variables");
                arquivo_entrada.flush();
                arquivo_entrada.close();
            }
            catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Could not create input file", "Warning",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
