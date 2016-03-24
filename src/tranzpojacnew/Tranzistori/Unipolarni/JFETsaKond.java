/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Tranzistori.Unipolarni;

import static java.lang.Math.sqrt;

/**
 *
 * @author Korisnik
 */
public class JFETsaKond {
    
    private double udd;
    private double rG;
    private double rD;
    private double rs;
    private double rg;
    private double rt;
    private double ugso;
    private double up;
    private double idss;
    private double idssMa;
    private double mi;
    private double uul;
    
    private double rul;
    private double ugsq;
       
    private double idq;
    private double idqMa;
    private double udsq;
    private double gm;
    private double gmmA; //mnozenje zbog prikaza u mA/v
    private double rd;
    private double rdrD;   // rd||rD
    private double rdrDrt;   // rd||rD||rt
    private double av;
    private double ai;
    private double rizl;
    private double uizl;
    
    private double RdRs; //mnozi se sa 1000 zbog prikaza u mA
    private double uddRdRs; //mnozi se sa 1000 zbog prikaza u ma
    private double RdRt; //mnozenje zbog mA
    private double idqudsq; //mnozenje zbog mA

    public JFETsaKond(double udd, double rG, double rD, double rs, double rg, double rt, double ugso, double idss, double mi, double uul) {
        this.udd = udd;
        this.rG = rG;
        this.rD = rD;
        this.rs = rs;
        this.rg = rg;
        this.rt = rt;
        this.ugso = ugso;
        this.idss = idss;
        this.mi = mi;
        this.uul = uul;
        
        idssMa = idss/1000;
        
        //postavljanje vrijednosti clanova kvadratne jednadzbe za kasnije lakse
        //racunanje
        double a = 1;
        double b = (-2*ugso)+((ugso*ugso)/(rs*idssMa));
        double c = ugso*ugso;
    
        double ugsq1 = (-b + sqrt((b*b)-(4*a*c)))/(2*a);  
        double ugsq2 = (-b - sqrt((b*b)-(4*a*c)))/(2*a);
      
        int uvijet = Double.compare(ugsq1, ugso);
        if (uvijet > 0){this.ugsq = ugsq1;}
        else {this.ugsq = ugsq2;}
             
        idq = idssMa * ((1- (ugsq/ugso))*(1- (ugsq/ugso)));
        idqMa = idq * 1000; //mnozenje zbog prikaza u mA
        udsq = udd - idq*(rs+rD);
        up = -ugso;
        gm = ((2*idssMa)/up)*(1+(ugsq/up));
        gmmA = gm * 1000; //mnozenje zbog prikaza u mA/v
        rd = mi/gm;
        rdrD = (rd*rD)/(rd+rD);   // rd||rD
        rdrDrt = (rdrD*rt)/(rdrD+rt);   // rd||rD||rt
        av = -gm * rdrDrt;
        rul = rG;
        ai = -av * rul/rt;
        rizl = rdrD;
        uizl = ((rul/(rul+rg)) * uul)*av;
    
        RdRs = (-1/(rD+rs)) * 1000; //mnozi se sa 1000 zbog prikaza u mA
        uddRdRs = (udd /(rD+rs)) * 1000; //mnozi se sa 1000 zbog prikaza u ma
        
        RdRt = (-1/((rD*rt)/(rD+rt))) * 1000; //mnozenje zbog mA
        idqudsq = (idq + (udsq/((rD*rt)/(rD+rt)))) * 1000; //mnozenje zbog mA
    }
        

    //seteri
    public void setUdd(double udd) {this.udd = udd;}

    public void setrG(double rG) {this.rG = rG;}
    
    public void setrD(double rD) {this.rD = rD;}

    public void setRs(double rs) {this.rs = rs;}
    
    public void setRg(double rg) {this.rg = rg;}

    public void setUgso(double ugso) {this.ugso = ugso;}

    public void setIdss(double idss) {this.idss = idss;}

    public void setMi(double mi) {this.mi = mi;}
    
    //geteri
    public double getRul() {return rul;}

    public double getUgsq() {return ugsq;}

    public double getIdq() {return idqMa;}

    public double getUdsq() {return udsq;}

    public double getGm() {return gmmA;}

    public double getRd() {return rd;}

    public double getAv() {return av;}

    public double getAi() {return ai;}

    public double getRizl() {return rizl;}
    
    public double getUizl() {
        if(uizl >= udd) return udd;
        else return uizl;    
    }
    
    public String getSRP() {
        return "Id= " + String.format("%.2f", RdRs) + " Uds+ " +
                String.format("%.2f", uddRdRs) + " mA";
    }
    
    public String getDRP() {
        return "id= " + String.format("%.2f", RdRt) + " uds+ " +
        String.format("%.2f", idqudsq) + " mA";
    } 
    
    public double getRdRs() {return RdRs;}

    public double getUddRdRs() {return uddRdRs;}

    public double getRdRt() {return RdRt;}

    public double getIdqudsq() {return idqudsq;}
    
}
