/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Tranzistori.Bipolarni.SZE;

/**
 * 
 * @author MatijaKrsic
 */
public class SZEbezKond {
    
    private double ucc; 
    private double r1;
    private double r2;
    private double rc;
    private double re;
    private double hfe;
    private double rt;
    private double rg;
    private double ubeq;
    private double uul;
        
    private double ubb;        
    private double rbb;
    private double ibq;
    private double ibqua;  //varijabla za prikaz u uA
    private double icq;
    private double icqma;  //varijabla za prikaz u mA
    private double uceq;
    private double hie;
    private double av;
    private double rul;
    private double rizl;
    private double uulpoj;
    private double uizl; 
    private double ai;
        
    private double RcRe;
    private double uccRcRe;
        
    private double RcRtRe;
    private double icquceq;

    public SZEbezKond(double ucc, double r1, double r2, double rc, double re, double hfe, double rt, double rg, double ubeq, double uul) {
        this.ucc = ucc;
        this.r1 = r1;
        this.r2 = r2;
        this.rc = rc;
        this.re = re;
        this.hfe = hfe;
        this.rt = rt;
        this.rg = rg;
        this.ubeq = ubeq;
        this.uul = uul;
        
        ubb = (r2/(r1+r2))*ucc;        
        rbb = (r1*r2)/(r1+r2);
        ibq = ((ubb-ubeq)/(rbb+((1+hfe)*re)));
        ibqua = ibq * 1000000;  //mnozenje za prikaz u uA
        icq = hfe * ibq;
        icqma = icq * 1000;     //mnozenje za prikaz u mA
        uceq = ucc - ((rc+re)*icq);
        hie = 0.025/ibq;
        av = -hfe * (((rc*rt)/(rc+rt))/(hie+(1+hfe)*re));
        rul = (rbb*(hie+((1+hfe)*re)))/(rbb+(hie+((1+hfe)*re)));
        rizl = rc;
        uulpoj = uul * (rul/(rul+rg));
        uizl = uulpoj * av; 
        ai = -av * (rul/rt);
        
        RcRe = (-1/(rc+re)) * 1000;      //mnozi se sa 1000 zbog prikaza u mA
        uccRcRe = (ucc /(rc+re)) * 1000; //mnozi se sa 1000 zbog prikaza u mA
        
        RcRtRe = (-1/((rc*rt)/(rc+rt)+re)) * 1000;            //mnozenje zbog prikaza u mA
        icquceq = (icq + (uceq/((rc*rt)/(rc+rt)+re))) * 1000; //mnozenje zbog prikaza u mA
    }

    //seteri
    public void setUcc(double ucc) {this.ucc = ucc;}

    public void setR1(double r1) {this.r1 = r1;}

    public void setR2(double r2) {this.r2 = r2;}

    public void setRc(double rc) {this.rc = rc;}

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
        if(Math.abs(uizl) >= ucc) return -ucc;
        else return uizl;    
    }
   
    public double getAi() {return ai;}
       
    public String getSRP() {
        return "Ic= " + String.format("%.2f", RcRe) + " Uce+ " +
                String.format("%.2f", uccRcRe) + " mA";
    }
    
    public String getDRP() {
        return "ic= " + String.format("%.2f", RcRtRe) + " uce+ " +
        String.format("%.2f", icquceq) + " mA";
    }
 
    
    public double getRcRe() {return RcRe;}

    public double getUccRcRe() {return uccRcRe;}

    public double getRcRtRe() {return RcRtRe;}

    public double getIcquceq() {return icquceq;}
   
    
}

