package com.liangjiahao.service;

import com.liangjiahao.dao.DbOperate;
import com.liangjiahao.model.Member;
import com.liangjiahao.view.FalseDialog;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ExcelIO {
    public static Member mem;
    public static ArrayList<Member> al;

    public ExcelIO() {
    }

    public static void outTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));

        int i;
        for(i = 0; i < model.getColumnCount(); ++i) {
            bWriter.write(model.getColumnName(i));
            bWriter.write("\t");
        }

        bWriter.newLine();

        for(i = 0; i < model.getRowCount(); ++i) {
            for(int j = 0; j < model.getColumnCount(); ++j) {
                bWriter.write(model.getValueAt(i, j).toString());
                bWriter.write("\t");
            }

            bWriter.newLine();
        }

        bWriter.close();
        System.out.println("write out to: " + file);
    }

    public static void main(String[] args) {
        inExcel("D:/test.xlsx");
    }

    public static void inExcel(String string) {
        try {
            Workbook wb = null;
            if (string.endsWith("xlsx")) {
                wb = new XSSFWorkbook(new FileInputStream(string));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(string));
            }

            Sheet sheet = ((Workbook)wb).getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            while(true) {
                Row row;
                do {
                    if (!rows.hasNext()) {
                        ((Workbook)wb).close();
                        return;
                    }

                    row = (Row)rows.next();
                } while(row.getCell(0) == null);

                Vector<String> v = new Vector();

                for(int i = 0; i < 8; ++i) {
                    v.add(row.getCell(i) == null ? "" : String.valueOf(row.getCell(i)));
                }

                mem = new Member((String)v.get(0), (String)v.get(1), (String)v.get(2), (String)v.get(3), (String)v.get(4), (String)v.get(5), (String)v.get(6), (String)v.get(7));
                DbOperate.addMember(mem);
            }
        } catch (IOException var7) {
            FalseDialog.getFalseDialog("读取失败！");
            var7.printStackTrace();
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
