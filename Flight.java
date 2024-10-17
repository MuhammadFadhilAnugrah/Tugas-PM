class Passenger {
    String name;
    Passenger next;
    
    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);

        if (head == null) {
            head = newPassenger;
        } else {
            Passenger temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPassenger;
        }
        System.out.println(name + " telah ditambahkan ke penerbangan.");
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Tidak ada penumpang yang dapat dihapus.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari penerbangan.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            System.out.println(name + " telah dihapus dari penerbangan.");
        } else {
            System.out.println(name + " tidak ditemukan dalam daftar penumpang.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Tidak ada penumpang dalam penerbangan.");
            return;
        }

        Passenger temp = head;
        System.out.println("Daftar penumpang dalam penerbangan:");
        while (temp != null) {
            System.out.println("- " + temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.addPassenger("Alice");
        flight.addPassenger("Bob");
        flight.addPassenger("Charlie");

        flight.displayPassengers();

        flight.removePassenger("Bob");

        flight.displayPassengers();

        flight.removePassenger("David");
    }
}
