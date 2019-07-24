/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.geom.Rectangle2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.IOException;
import javax.swing.JEditorPane;

/**
 *
 * @author Administrador
 */
public class TestPrinting01 {

    private static JEditorPane editor;

    public static void main(String[] args) {

        try {
            

            editor = new JEditorPane();
            editor.setSize(Short.MAX_VALUE,Short.MAX_VALUE);
            editor.setPage(new File("C:/print.html").toURI().toURL());
            editor.revalidate();
            editor.repaint();

            PrinterJob pj = PrinterJob.getPrinterJob();
            if (pj.printDialog()) {
                PageFormat pf = pj.defaultPage();
                Paper paper = pf.getPaper();
                double width = 3.14961d * 72d;
                double height = editor.getPreferredSize().getHeight()+(2*(0.19685d * 72d));
                double margin = 0.19685d * 72d;

                double widthR = width - (2*(0.19685d * 72d)) ;
                editor.setSize((int) widthR,editor.getHeight());
                
                paper.setSize(width, height);
                
                System.err.println("Tamaño del Editor: "+widthR+":"+height);
                
                paper.setImageableArea(
                        margin,
                        margin,
                        width - (margin * 2),
                        height - (margin * 2));
                System.out.println("Before- " + dump(paper));
                pf.setOrientation(PageFormat.PORTRAIT);
                pf.setPaper(paper);
                System.out.println("After- " + dump(paper));
                System.out.println("After- " + dump(pf));
                dump(pf);
                PageFormat validatePage = pj.validatePage(pf);
                System.out.println("Valid- " + dump(validatePage));

                Book pBook = new Book();
                pBook.append((Printable) new Page(), pf);
                pj.setPageable(pBook);

                try {
                    pj.print();
                } catch (PrinterException ex) {
                }
            }

        } catch (HeadlessException | IOException | IllegalArgumentException | NullPointerException exp) {
        }
    }

    protected static String dump(Paper paper) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(paper.getWidth()).append("x").append(paper.getHeight())
                .append("/").append(paper.getImageableX()).append("x").
                append(paper.getImageableY()).append(" - ").append(paper
                .getImageableWidth()).append("x").append(paper.getImageableHeight());
        return sb.toString();
    }

    protected static String dump(PageFormat pf) {
        Paper paper = pf.getPaper();
        return dump(paper);
    }

    public static class Page implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
            if (pageIndex >= 1) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            // Be careful of clips...
//            g2d.setClip(0, 0, (int) pageFormat.getWidth(), (int) pageFormat.getHeight());
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            double width = pageFormat.getImageableWidth();
            double height = pageFormat.getImageableHeight();

            System.out.println("width = " + width);
            System.out.println("height = " + height);

            editor.setLocation(0, 0);
            editor.setSize((int)width, (int)height);
            editor.printAll(g2d);

            g2d.setColor(Color.BLACK);
            g2d.draw(new Rectangle2D.Double(0, 0, width, height));

            return Printable.PAGE_EXISTS;
        }
    }
}
