/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Tranzistori.Bipolarni.SZC;

/**
 *
 * @author Korisnik
 */
public class SZC {
    
    private double ucc; 
    private double r1;
    private double r2;
    private double re;
    private double hfe;
    private double rt;
    private double rg;
    private double ubeq;
    private double uul;
        
    private double ubb;        
    private double rbb;
    private double ibq;
    private double ibqua;  //za prikaz u uA
    private double icq;
    private double icqma;        //za prikaz u mA
    private double uceq;
    private double hie;
    private double av;
    private double rul;
    private double rizl;
    private double uulpoj;
    private double uizl;       
    private double ai;
    
    double reRec; //mnozi se sa 1000 zbog prikaza u mA
    double uccRe; //mnozi se zbog prikaza u mA
        
    double ReRt; //mnozenje zbog mA
    double icquceq; //mnozenje zbog mA

    public SZC(double ucc, double r1, double r2, double re, double hfe, double rt, double rg, double ubeq, double uul) {
        this.ucc = ucc;
        this.r1 = r1;
        this.r2 = r2;
        this.re = re;
        this.hfe = hfe;
        this.rt = rt;
        this.rg = rg;
        this.ubeq = ubeq;
        this.uul = uul;
        
        ubb = (r2/(r1+r2))*ucc;        
        rbb = (r1*r2)/(r1+r2);
        ibq = ((ubb-ubeq)/(rbb+((1+hfe)*re)));
        ibqua = ibq * 1000000;  //za prikaz u uA
        icq = hfe * ibq;
        icqma = icq * 1000;        //za prikaz u mA
        uceq = ucc - (re*icq);
        hie = 0.025/ibq;
        av = ((1+hfe)*((re*rt)/(re+rt))) / (((1+hfe)*((re*rt)/(re+rt)))+hie);
        rul = ((rbb*hie)/(rbb+hie))+((1+hfe)*((re*rt)/(re+rt)));
        rizl = (re*(hie+((rg*rbb)/(rg+rbb)))) / ((1+hfe)*re+((rg*rbb)/(rg+rbb))+hie);
        uulpoj = uul * (rul/(rul+rg));
        uizl = uulpoj * av;       
        ai = -av * (rul/rt);   
    
        reRec = (-1/re) * 1000; //mnozi se sa 1000 zbog prikaza u mA
        uccRe = (ucc /re) * 1000; //mnozi se zbog prikaza u mA
        
        ReRt = (-1/((re*rt)/(re+rt))) * 1000; //mnozenje zbog mA
        icquceq = (icq + (uceq/((re*rt)/(re+rt)))) * 1000; //mnozenje zbog mA
    }
    
    

    //seteri
    public void setUcc(double ucc) {this.ucc = ucc;}

    public void setR1(double r1) {this.r1 = r1;}

    public void setR2(double r2) {this.r2 = r2;}

    public void setRe(double re) {this.re = re;}

    public void setHfe(double hfe) {this.hfe = hfe;}

    public void setRt(double rt) {this.rt = rt;}

    public void setRg(double rg) {this.rg = rg;}

    public void setUbeq(double ubeq) {this.ubeq = ubeq;}
    
    public void setUul(double uul) {this.uul = uul;}
    
    //geteri
    public double getUbb() {return ubb;}

    public double getRbb() {return rbb;}

    public double getIbqua() {return ibqua;}

    public double getIcqma() {return icqma;}

    public double getUceq() {return uceq;}

    public double getHie() {return hie;}

    public double getAv() {return av;}

    public double getRul() {return rul;}

    public double getRizl() {return rizl;}
    
    public double getUizl() {
        if(uizl >= ucc) return ucc;
        else return uizl;    
    }
    
    public double getAi() {return ai;}
    
    public String getSRP() {
        return "Ic= " + String.format("%.2f", reRec) + " Uce+ " +
                String.format("%.2f", uccRe) + " mA";
    }
    
    public String getDRP() {
        return "ic= " + String.format("%.2f", ReRt) + " uce+ " +
        String.format("%.2f", icquceq) + " mA";
    }
}
