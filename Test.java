package RSA;

import java.math.BigInteger;

public class Test {
	public static void main(String[] args) {
		BigInteger p = new BigInteger("e86c7f16fd24818ffc502409d33a83c2a2a07fdfe971eb52de97a3de092980279ea29e32f378f5e6b7ab1049bb9e8c5eae84dbf2847eb94ff14c1e84cf568415", 16);
		BigInteger q = new BigInteger("d7d9d94071fcc67ede82084bbedeae1aaf765917b6877f3193bbaeb5f9f36007127c9aa98d436a80b3cce3fcd56d57c4103fb18f1819d5c238a49b0985fe7b49", 16);
		BigInteger e = new BigInteger("10001", 16);
		RSA rsa = new RSA(p, q, e);
		System.out.println("p=" + p.toString(16));
		System.out.println("q=" + q.toString(16));
		System.out.println("n=" + rsa.n.toString(16));
		System.out.println("φ(n)=" + rsa.getPhi_n().toString(16));
		System.out.println("e=" + e.toString(16));
		System.out.println("d=" + rsa.getD().toString(16));
		BigInteger plaintext = new BigInteger("b503be7137293906649e0ae436e29819ea2d06abf31e10091a7383349de84c5b", 16);
		System.out.println("明文：" + plaintext.toString(16));
		BigInteger ciphertext = RSA.encrypt(plaintext, rsa.n, e);
		System.out.println("密文：" + ciphertext.toString(16));
		System.out.println("明文：" + RSA.decrypt(ciphertext, rsa.n, rsa.getD()).toString(16));
	}
}