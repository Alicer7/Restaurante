/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.themplate;

import java.util.ArrayList;

/**
 *
 * @author Freddy
 */
public class Factura {
    private final String css="html{font-size:62.5%}body{font-size:1.6rem;font-family:\"Open Sans\",sans-serif;color:#333;padding:2rem 0}@media print{body{-webkit-print-color-adjust:exact}}.hd{display:flex;align-items:center;justify-content:space-between;padding-bottom:2.5rem;border-bottom:1px solid #e6e7e8}.hd>img{max-width:30rem}.hd-info{color:#58595b}.hd-info>h2{font-size:3.2rem;font-weight:400}.hd-info>div{font-size:2.1rem}.t1{text-align:center;margin:3.6rem 0;font-size:4.2rem;font-weight:300;color:#6d6e71}.ref{background-color:#e6e7e8;padding:1.6rem 0;text-align:center}.ref-l1{font-size:2.4rem;font-weight:700}.ref-l2{font-size:2rem;margin-top:.5rem}.tbl{width:100%}.tbl thead th{border-bottom:1px solid #e6e7e8;padding:1.8rem 0 1.8rem 0;font-weight:400;font-size:2rem;color:#a7a9ac}.tbl thead th:first-child{text-align-last:left;padding-left:5rem}.tbl thead th: last-child{text-align:right;padding-right:5rem}.tbl tbody tr td{text-align:center;font-size:2.4rem;padding:1.8rem 0 1.8rem 0}.tbl tbody tr td:first-child{padding-left:5rem;text-align:left}.tbl tbody tr td: last-child{padding-right:5rem;text-align:right}.tbl tbody tr: last-child td{border-bottom:1px solid #e6e7e8}.tbl tfoot tr td{color:#a7a9ac;padding:1.2rem 0 1.2rem 0;font-size:2.4rem;text-align:right}.tbl tfoot tr td:first-child{text-align-last:left;padding-left:5rem}.tbl tfoot tr td: last-child{text-align-last:right;padding-right:5rem}.tbl tfoot .total td{border-bottom:1px solid #e6e7e8;border-top:1px solid #e6e7e8;font-size:3rem;font-weight:700;color:#333}.addr{margin-top:3.5rem}.addr>:first-child{background-color:#e6e7e8}.addr-head{font-size:2.4rem;padding:.5rem 0;text-align:center;display:flex}.addr-head>div{width:50%}.addr-body{display:flex;text-align:center;padding:2rem 0;font-size:2.4rem;color:#a7a9ac;border-bottom:1px solid #e6e7e8}.addr-body>div{width:50%}.note{margin-top:3.5rem;background-color:#e6e7e8;padding:1rem 0}.note>div{font-size:2rem;color:#a7a9ac}.note>div>span{color:#333}.cnt{margin-left:4.5rem;margin-right:4.5rem}";
    private final String head = "<head><meta charset=\"UTF-8\"> <title>Factura</title> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <style>"+css+"</style></head>";
    private String content;
    private String body;
    private String html;
    
    public Factura() {
    }
    
    private void div (){
        String div = "";
        String divcnt = "";
    }
    
    private void teble (){
    }
    
    private void body (ArrayList<String> lista){
        String body = "<body translate=\"no\">"+content+"</body>";
        this.body = body;
    }
    
    public String getTemplate (){
        
        String htmlTop = "<!DOCTYPE html> <html lang=\"es\">";
        String htmlMid = head+body;
        String htmlBot = "</html>";
        
        this.html = htmlTop+htmlMid+html;
        return this.html;
    }
    
}
