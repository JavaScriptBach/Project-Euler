import java.util.*;
import java.io.*;
public class Problem59 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("cipher1.txt"));
		PrintStream output = new PrintStream(new File("output2.txt"));
		String[] message = input.next().split(",");
		int[] realmessage = new int[message.length];
		for (int i = 0; i < message.length; i++)
			realmessage[i] = Integer.parseInt(message[i]);
		int[] key = new int[realmessage.length];
		/*SortedMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		for (int i: realmessage){
			if (!m.containsKey(i))
				m.put(i, 1);
			else
				m.put(i, m.get(i) + 1);
		}
		for (int i: m.keySet())
			System.out.println(i + ": " + m.get(i));*/
		
		/*for (int i = 97; i <= 122; i++){
			for (int j = 97; j <= 122; j++){
				for (int k = 97; k <= 122; k++){
					for (int l = 0; l < 1200; l+=3){
						key[l] = i;
						key[l+1] = j;
						key[l+2] = k;
					}
					key[1200] = i;
					decode(realmessage, key, output);
				}
			}
		}*/
		String answer = "(The Gospel of John, chapter 1) 1 In the beginning the Word already existed. He was with God, and he was God. 2 He was in the beginning with God. 3 He created everything there is. Nothing exists that he didn't make. 4 Life itself was in him, and this life gives light to everyone. 5 The light shines through the darkness, and the darkness can never extinguish it. 6 God sent John the Baptist 7 to tell everyone about the light so that everyone might believe because of his testimony. 8 John himself was not the light; he was only a witness to the light. 9 The one who is the true light, who gives light to everyone, was going to come into the world. 10 But although the world was made through him, the world didn't recognize him when he came. 11 Even in his own land and among his own people, he was not accepted. 12 But to all who believed him and accepted him, he gave the right to become children of God. 13 They are reborn! This is not a physical birth resulting from human passion or plan, this rebirth comes from God.14 So the Word became human and lived here on earth among us. He was full of unfailing love and faithfulness. And we have seen his glory, the glory of the only Son of the Father.";
		int sum = 0;
		for (int i = 0; i < answer.length(); i++)
			sum += answer.charAt(i);
		System.out.println(sum);

	}
	
	public static void decode(int[] message, int[] key, PrintStream output) throws FileNotFoundException{
		for (int i = 0; i < message.length; i++)
			output.print((char)(message[i] ^ key[i]));
		output.println();
	}

}
