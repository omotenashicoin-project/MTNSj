package site.mtnsj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {

    public static final String coinName = "OmotenashiCoin";
    public static final String coinTicker = "MTNS";
    public static final String coinURIScheme = "omotenashicoin";
    public static final String cryptsyMarketId = "193";// kani?
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[13]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[T]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/xxx/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://mtns.hashexplorer.net/";      // do not use blockexplorer functions 
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";                                 //
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";                                  //
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                                     //

    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://mtns.hashexplorer.net:3002/";
    public static final String DONATION_ADDRESS = "MqUzZu4sXRCViBrhGkxfy1YuyLQZb4n7zf";  //OmotenashiCoin Project donation MTNS address

    enum CoinHash {
        SHA256,
        scrypt,
        x11,
        skein
    };


    public static final CoinHash coinPOWHash = CoinHash.skein;

    public static boolean checkpointFileSupport = true;
    public static final int TARGET_TIMESPAN = (int)(1.5 * 60);  // 1.5 minutes per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1.5 * 60);   // 1.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //1 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 330000000;                 //main.h:  330mili MAX_MONEY

    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE kaniTODO
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE kaniTODO
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1) kaniTODO

    public static final long DEFAULT_TX_FEE = 10 * 100 * 1000000;   // main.h -> minRelayTxFee, 10 MTNS per kb kaniTODO
    public static final boolean feeCanBeRaised = false;

    //
    // MTNS 1.2.0
    //
    public static final int PROTOCOL_VERSION = 70015;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70015;        //version.h MIN_PROTO_VERSION do not use.
    public static final int BLOCK_CURRENTVERSION = 3;   // 2 -> 1 CBlock::CURRENT_VERSION todoKANI
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 16181;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 16281;     //protocol.h GetDefaultPort(testnet=true)

    /** Zerocoin starting block height */
    public static final long TESTNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 201564; // kaniTODO do not use.
    public static final long MAINNET_ZEROCOIN_STARTING_BLOCK_HEIGHT = 2147483647; // do not use.

    //
    //  Production
    //
    public static final int AddressHeader = 65;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS T
    public static final int p2shHeader = 13;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS 6

    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xd3b7a7df;


    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1558828800L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (251150L);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000ff90e7386dcd26a94b20068ef9855fb2330f4713ae6aaa2f49d81e9e92a"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "b263699f563491d3c58855d0bb238073f5d419f4bbc4d0120251d4aaaffc3177";
    static public int genesisBlockValue = 1;                                                              //main.cpp: LoadBlockIndex
    
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01042d4c6561726e206d6f7265206174204e6174696f6e616c2056756c6e65726162696c697479204461746162617365";
    static public String genesisTxOutBytes = "042174344a54c5fcea1e9264714fc4a91a61910fb085ca44e2f8925262f17b7b94a2b5d3a32ffe7f383d6806780df0b20bfef07ae19c2d8b58d734d5cee45768da";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "45.32.219.61",
            "95.179.192.77",
    };

    public static int minBroadcastConnections = 3;   //0 for default; we need more peers.

    //
    // TestNet
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 83;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 18;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x63436454;      //
    public static final String testnetGenesisHash = "0000075ac34da1908cfc20e56b93a7fcb61f6b6782767b68a42e293e582461f5";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1509321601L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (2007907L);                         //main.cpp: LoadBlockIndex



    public static int GetBlockOffset(int nHeight)
    {

        int cnt = 0;
        int crentValue = nHeight + 1;
        int tBlockStep = 45000;
        int offsetKind = 9;

        for(;;){
            cnt++;
            if (cnt > offsetKind) cnt = 1;
            crentValue = crentValue - tBlockStep ;
            if (crentValue <= 0)
                break;
        }

        return cnt;

    }

    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int nHeight)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(0, 0);
        int offset = 0;

        /* pre-mine */
        if (nHeight >= 0 && nHeight < 5 ) {
            return Coin.valueOf(10000, 0);
        } else if ( nHeight == 5 ) {
            return Coin.valueOf(450000, 0);
        } else if ( nHeight == 6 ) {
            return Coin.valueOf(16000000, 0);
        } else if ( nHeight < 80 ) {
            return Coin.valueOf(1, 0);
        }

        offset = GetBlockOffset(nHeight);

        if ( offset == 1) {
            nSubsidy = Coin.valueOf(200, 0);
        } else if  ( offset == 2 ) {
            nSubsidy = Coin.valueOf(10, 0);
        } else if ( offset == 3 ) {
            nSubsidy = Coin.valueOf(5, 0);
        } else if ( offset == 4) {
            nSubsidy = Coin.valueOf(50, 0);
        } else if ( offset == 5) {
            nSubsidy = Coin.valueOf(1, 0);
        } else if ( offset == 6) {
            nSubsidy = Coin.valueOf(2, 0);
        } else if ( offset == 7) {
            nSubsidy = Coin.valueOf(3, 0);
        } else if ( offset == 8) {
            nSubsidy = Coin.valueOf(5, 0);
        } else if ( offset == 9) {
            nSubsidy = Coin.valueOf(7, 0);
        }

        return nSubsidy;

    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "95.179.192.77"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "0408cbbe0018cb99d62c237aff5d82fe90cf316d7d52a4eac25ce96f9ba307f78e07f34094d1c7485a107be045c9a80256de7a728d22213ad523e879e2e1cc1469";
    public static final String TESTNET_SATOSHI_KEY = "04e9e89f0e79a4236a4ad75ecb6500587faa26338fbc46624c95726a4c76264e618127c7c30f77b62196c0e163fcfbd5d75d076e8032b733ef33a2bc8f0c33ec40";


    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "site.mtns.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "site.mtns.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.mtns.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        //checkpoints.put(  0, Sha256Hash.wrap("0000057a372928aa35f432dc3bd5c58275a0219e7743eea71ad3ffd6f7e78b85"));
        checkpoints.put(       0, Sha256Hash.wrap("00000ff90e7386dcd26a94b20068ef9855fb2330f4713ae6aaa2f49d81e9e92a"));
        checkpoints.put(       1, Sha256Hash.wrap("00000703104725776df70f5efd27cb1f966fbaba32d2dcd317f54c85383db9d2"));
        checkpoints.put(       2, Sha256Hash.wrap("0000061dc8037f061f69e9d8ead5026e0f9934f0c8d306f4adf74901abe264b7"));
        checkpoints.put(       3, Sha256Hash.wrap("00000b9753bc870a0d2ab9084aca9ac4a88517bb0c3105fe7ebbadabfbc84af8"));
        checkpoints.put(       4, Sha256Hash.wrap("000007e9154810b08def70d3fa2d4987a02d6edf5f423a691aa1c5d3fcab70b1"));
        checkpoints.put(       5, Sha256Hash.wrap("00000c4c11c01530922e755fbe2714301892244154f328696adc608f1c262b39"));
        checkpoints.put(       6, Sha256Hash.wrap("00000adbb904433a2d9c8a8e23ac677d2b8cea2584002e9c0bd012b79d443d48"));
        checkpoints.put(       7, Sha256Hash.wrap("000000ce9d6b53a8c00cc005474ab2f0ff65e1ac92268c88aca51c312228dba6"));
        checkpoints.put(       8, Sha256Hash.wrap("000008dc9bcef4bee2c0e3c2efe725b778baa6f5fda2168fb246b738f774761d"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "MvRLbC1q5zq3SMCa5vBDy14hVGVEuo5uSw";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
