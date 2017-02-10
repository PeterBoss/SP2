import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * <h2>Task 2</h2>
 * <p>
 * Now that you implemented a server it's time to run it! Create a client which sends the bytes from the
 * {@link #MESSAGE} constant to the server.
 * </p>
 * <p>
 * First try to create a UDP socket with the {@link InetSocketAddress} to the server as a constructor argument
 * to the {@link DatagramSocket}. Before doing anything else, try to run this code. Does it give an exception?
 * Why/Why not? And what would a TCP socket do?
 * </p>
 * <p>
 * Second, send the text message from the {@link #MESSAGE} constant to the server and check to see what is actually
 * received.
 * </p>
 */
public class UdpClient {

    // This is horrifyingly hilariously bad movie
    private static final byte[] MESSAGE =
            "We are all interested in the future, for that is where you and I will spend the rest of our lives!".getBytes(); // Plan 9 from Outer Space"

    public static void main(String[] args) throws SocketException, IOException {
        // 1. Create a socket and connect it to the server
        // 2. Try to start the socket without the server. Do you get an exception? Why/Why not?
        // 3. Start the server and send the message from above to the server. What are you receiving?
        
        DatagramSocket socket = new DatagramSocket();

        socket.connect(new InetSocketAddress("localhost", 8080));
        socket.send(new DatagramPacket(MESSAGE, MESSAGE.length));
    }

}
