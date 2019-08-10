package com.twu.biblioteca.service;

import com.twu.biblioteca.model.BookCheckoutRecord;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class BookCheckoutRecordService {
    ArrayList<BookCheckoutRecord> recordList = new ArrayList<>(Arrays.asList(new BookCheckoutRecord("The Catcher in the Rye", "c00-0001"),
            new BookCheckoutRecord("Flipped","c00-0001")));

    LoginService loginService = new LoginService();

    public ArrayList<ArrayList> getCheckoutRecord(){
        ArrayList<ArrayList> records = new ArrayList();
        for (BookCheckoutRecord bookCheckoutRecord:recordList){
            ArrayList arrayList = new ArrayList();
            User user = loginService.getInfoById(bookCheckoutRecord.getUserId());
            arrayList.add(bookCheckoutRecord.getBookTitle());
            arrayList.add(bookCheckoutRecord.getUserId());
            arrayList.add(user.getUserName());
            records.add(arrayList);
        }
        return records;
    }
}
