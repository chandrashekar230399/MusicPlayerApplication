package com.chandu;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String name;
	private String artist;
	private ArrayList<Songs> songs;

	public Album(String name, String artist) {

		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Songs>();
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Songs findsong(String title) {
		for (Songs checkedSongs : songs) {
			if (checkedSongs.getTitle().equals(title)) {
				return checkedSongs;
			}

		}
		return null;

	}

	public boolean addSong(String title, double duration) {
		if (findsong(title) == null) {
			songs.add(new Songs(title, duration));
			System.out.println(title + "sucessfully added to the list");
			return true;
		} else {

			System.out.println("song with name " + title + "already exit in the list");
			return false;
		}
	}

	public boolean addToPlayList(int trackNumber, LinkedList<Songs> PlayList) {
		int index = trackNumber - 1;
		if (index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
		System.out.println("this album does not have any song with tracknumber" + trackNumber);
		return false;
	}

	public boolean addToPlayList(String title, LinkedList<Songs> PlayList) {
		for (Songs checkedSong : songs) {
			if (checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
				return true;
			}

		}
		System.out.println(title + "there is no such song in album");
		return false;
	}

	
	

}
