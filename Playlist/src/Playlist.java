class Song {
    String title;
    Song next;

    public Song(String title) {
        this.title = title;
        this.next = null;
    }
}

class Playlist {
    private Song head;

    public Playlist() {
        this.head = null;
    }

    public void addSong(String title) {
        Song newSong = new Song(title);

        if (head == null) {
            head = newSong;
        } else {
            Song temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newSong;
        }
        System.out.println("Lagu '" + title + "' telah ditambahkan ke playlist.");
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Song temp = head;
        System.out.println("Daftar lagu dalam playlist:");
        while (temp != null) {
            System.out.println("- " + temp.title);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Lagu A");
        playlist.addSong("Lagu B");
        playlist.addSong("Lagu C");
        playlist.displayPlaylist();
    }
}
