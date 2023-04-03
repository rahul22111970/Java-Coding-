import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        List<Block> blockchain = new ArrayList<>();
        Block genesisBlock = new Block(0, "0", names, 100);
        blockchain.add(genesisBlock);
        
        for (int i = 1; i <= 3; i++) {
            Block previousBlock = blockchain.get(i-1);
            Block newBlock = new Block(i, previousBlock.hash, names, 100);
            blockchain.add(newBlock);
        }
        
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }

}

class Block {
    public int index;
    public long timestamp;
    public String hash;
    public String previousHash;
    public List<String> names;
    public int balance;

    public Block(int index, String previousHash, List<String> names, int balance) throws NoSuchAlgorithmException {
        this.index = index;
        this.timestamp = System.currentTimeMillis();
        this.previousHash = previousHash;
        this.names = names;
        this.balance = balance;
        this.hash = calculateHash();
    }

    public String calculateHash() throws NoSuchAlgorithmException {
        String data = index + previousHash + names.toString() + balance + timestamp;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String toString() {
        return "Block [index=" + index + ", timestamp=" + timestamp + ", hash=" + hash + ", previousHash=" + previousHash
                + ", names=" + names + ", balance=" + balance + "]";
    }
}
