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
//The BlockchainDemo class is the main class that creates a list of names and initializes the blockchain with a genesis block, which is the first block in the blockchain. Then it creates three more blocks and adds them to the blockchain. Finally, it prints out the contents of each block in the blockchain.

//The Block class represents a block in the blockchain. It contains an index to identify the block, a timestamp to record when the block was created, a hash to uniquely identify the block, a previous hash to link the block to the previous block in the chain, a list of names, and a balance for each name. The calculateHash() method uses the SHA-256 algorithm to generate a unique hash for the block based on its contents.
