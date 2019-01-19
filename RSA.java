package RSA;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
	private BigInteger p, q;
	/**
	 * n=pq
	 */
	public BigInteger n;
	/**
	 * φ(n)=(p-1)(q-1)
	 */
	private BigInteger phi_n;
	public BigInteger e;
	/**
	 * ed=1(mod φ(n))
	 */
	private BigInteger d;

	public RSA() {
		p = BigInteger.probablePrime(new Random().nextInt(100) + 100, new Random());
		q = BigInteger.probablePrime(new Random().nextInt(100) + 100, new Random());
		n = p.multiply(q);
		phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		do {
			e = new BigInteger(new Random().nextInt(phi_n.bitLength() - 1) + 1, new Random());
		} while (e.compareTo(phi_n) != -1 || e.gcd(phi_n).intValue() != 1);
		d = e.modPow(new BigInteger("-1"), phi_n);
	}

	public RSA(BigInteger p, BigInteger q, BigInteger e) {
		this.p = p;
		this.q = q;
		n = p.multiply(q);
		phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		this.e = e;
		d = e.modPow(new BigInteger("-1"), phi_n);
	}

	public BigInteger getPhi_n() {
		return phi_n;
	}

	public BigInteger getD() {
		return d;
	}

	@Override
	public String toString() {
		return "n=" + n.toString(16) + "\ne=" + e.toString(16);
	}

	/**
	 * 加密
	 * <p> C=M^e(mod n)
	 * @param M
	 * @param n
	 * @param e
	 * @return
	 */
	public static BigInteger encrypt(BigInteger M, BigInteger n, BigInteger e) {
		return M.modPow(e, n);
	}

	/**
	 * 解密
	 * <p> M=C^d(mod n)
	 * @param C
	 * @param n
	 * @param d
	 * @return
	 */
	public static BigInteger decrypt(BigInteger C, BigInteger n, BigInteger d) {
		return C.modPow(d, n);
	}
}