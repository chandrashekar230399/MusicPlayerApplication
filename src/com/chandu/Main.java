package com.chandu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {

		Album album = new Album("VIKRAM", "ANIRUDH");
		album.addSong("Once Upon a Time", 4.5);
		album.addSong("Porata Simham", 3.5);
		album.addSong("Eagle is coming", 3.0);
		
		albums.add(album);

		album = new Album("RRR", "M M KEERAVANI");
		album.addSong("Naatu Naatu", 5.0);
		album.addSong("Komaram Bheemudo", 6.0);
		album.addSong("Dosthi", 5.0);

		albums.add(album);

		album = new Album("PUSPA-THE RULE", "D S P");
		album.addSong("Srivalli", 5.0);
		album.addSong("Saami Saami", 5.0);
		album.addSong("Eyy Bidda Idhi naa", 5.0);

		albums.add(album);

		LinkedList<Songs> playlist_l = new LinkedList<>();
		albums.get(0).addToPlayList("Once Upon a Time", playlist_l);
		albums.get(1).addToPlayList("Porata Simham", playlist_l);
		albums.get(2).addToPlayList("Saami Saami", playlist_l);
		albums.get(1).addToPlayList("Komaram Bheemudo", playlist_l);

		play(playlist_l);
	}

	private static void play(LinkedList<Songs> playList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your option:");
		String n = sc.nextLine();
		boolean quit = false;
		boolean forward = true;
		ListIterator<Songs> listIterator = playList.listIterator();

		if (playList.size() == 0) {
			System.out.println("this play list have no song");
		} else {
			System.out.println("Now playing" + listIterator.next().toString());
			printmenu();
		}

		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();

			switch (action) {

			case 0:
				System.out.println("playlist completed");
				quit = true;
				break;

			case 1:
				if (!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now playing" + listIterator.next().toString());
				} else {
					System.out.println("no song avaliable, reached to the end of the list");
					forward = false;

				}
				break;
			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.hasPrevious();
					}
					forward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now playing" + listIterator.previous().toString());
				} else {
					System.out.println("we are  the first song");
					forward = false;
				}
				break;
			case 3:
				if (forward) {

					if (listIterator.hasPrevious()) {
						System.out.println("Now playing" + listIterator.previous().toString());
						forward = false;
					} else {
						System.out.println("we are at  the start of the list");
						forward = false;
					}
				} else {
					if (listIterator.hasNext()) {
						System.out.println("now playing " + listIterator.next().toString());

						forward = true;
					} else {
						System.out.println("we has reached to the end of list");
					}
				}
				break;
				
			case 4:
				printList(playList);
				break;
			case 5:
				printmenu();
				break;
			case 6:
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("now playing"+listIterator.next().toString());
						forward = true;
					}
					else {
						if(listIterator.hasPrevious())
							System.out.println("now playing"+listIterator.previous().toString());
					}
				}
			}
		}
	}

	private static void printmenu() {
		System.out.println("Avaliable options\n  press");
		System.out.println("0 - to quit\n" + "1 - to play next song\n" + "2 - to play previous song\n"
				+ "3- to replay current song\n" + "4 - list of all songs\n" + "5 - print all above options\n"
				+ "6 - delete current song");
	}

	private static void printList(LinkedList<Songs> playList) {
		Iterator<Songs> iterator = playList.iterator();
		System.out.println("____________________________");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("____________________________");
	}

}
