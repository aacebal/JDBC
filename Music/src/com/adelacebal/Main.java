package com.adelacebal;

import com.adelacebal.model.Artist;
import com.adelacebal.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open data source");
            return;
        }

        List<Artist> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);s
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name: = " + artist.getName());
        }

        dataSource.close();
    }
}
