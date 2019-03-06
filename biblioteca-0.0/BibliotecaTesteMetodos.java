import java.util.Scanner;

public class BibliotecaTesteMetodos
{
	public static void main(String[] args)
	{
		// Programa para testar funcionamento dos métodos.
		Scanner teclado = new Scanner (System.in);
		Biblioteca biblioteca = new Biblioteca();
		
		String[] vetorAutores = {"AAA", "BBB", "CCC"};
		
		biblioteca.imprimeInformacoesLivros();


		biblioteca.cadastrarLivro("ccc", "DDD", "1234567890123", vetorAutores, 1);
		biblioteca.cadastrarLivro("aaa", "RRR", "azsxdcfvgbhnj", vetorAutores, 100);
		biblioteca.cadastrarLivro("bbb", "EEE", "1234567890133", vetorAutores, 10);
		// biblioteca.cadastrarLivro("ddd", "DDD", "12345678kwo23", vetorAutores, 1);
		// biblioteca.cadastrarLivro("ggg", "ASDA", "qwertyuiopasd", vetorAutores, 371);
		// biblioteca.cadastrarLivro("eee", "RRR", "azsxdcfv34tnj", vetorAutores, 100);
		// biblioteca.cadastrarLivro("fff", "TTT", "zaxscdvfbgnhm", vetorAutores, 1000);
		// biblioteca.cadastrarLivro("hhh", "EEE", "12317el890123", vetorAutores, 10);
		// biblioteca.cadastrarLivro("www", "Aaa", "6ucrgkf5x48kx", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("qqq", "Aaa", "5okj0tievkjtp", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("rrr", "Aaa", "6nfjbi9t0cu0l", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("AAA", "Aaa", "9tpqbp95z4jus", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("zzz", "Aaa", "0fojfyg6k5dhk", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("iii", "Aaa", "7rsx0si65f8a4", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("yyy", "JKL", "214qrt2ut3ez0", vetorAutores, 34);
		// biblioteca.cadastrarLivro("uuu", "Aaa", "9glvcf9ni3344", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ttt", "Aaa", "8tefolbsrjx69", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ooo", "Aaa", "4fdrokqyevfe6", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("jjj", "Aaa", "62xhjlxm7wyrn", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("nnn", "Aaa", "3wuei8iicfolc", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("vvv", "Aaa", "6hms47m3xnyy3", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("xxx", "Aaa", "859xpef1okkyw", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("zzz", "Aaa", "9h508dn4hb84e", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("kkk", "Aaa", "1z79lnkll3y6x", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("mmm", "JKL", "8tf4q04w1auyo", vetorAutores, 34);
		// biblioteca.cadastrarLivro("sss", "Aaa", "89qckebwgrmui", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ççç", "Aaa", "99elfxtdzrnf6", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("lll", "Aaa", "6r43boeny4nu0", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("asd", "Aaa", "18lhxysidgh1j", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("KKK", "Aaa", "57wjllggx1l8q", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("Zklj", "Aaa", "640bxw58wcpjr", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("BBB", "Aaa", "19hp0ylq4kcbh", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("RRR", "Aaa", "7v8i2w6s7c527", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("TTT", "JKL", "7dw40qxgqjv0j", vetorAutores, 34);
		// biblioteca.cadastrarLivro("EEE", "Aaa", "7bj1lrkcn07k9", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("WWW", "Aaa", "0ufz2ye4fbyoa", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("QQQ", "Aaa", "5257m1pr0zl4d", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("PPP", "Aaa", "0ch63vxvtv785", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("III", "Aaa", "7mco7cgwo6oie", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("UUU", "Aaa", "0md1ix4j02p6j", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("YYY", "Aaa", "5vi0fx650wwgk", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("TTT", "Aaa", "4hsqhvsshd8h6", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ppp", "Aaa", "9ggfm0f0riicv", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("MMM", "JKL", "7shrxwe99iy9t", vetorAutores, 34);
		// biblioteca.cadastrarLivro("JJJ", "Aaa", "8kjbzrxfdqmzq", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("OOO", "Aaa", "7qxenakhivgb5", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("SSS", "Aaa", "5wh5dq9l8bejs", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ZZZ", "Aaa", "0f266cqegkbe4", vetorAutores, 1234);				
		// biblioteca.cadastrarLivro("ccc", "DDD", "1234567890123", vetorAutores, 1);
		// biblioteca.cadastrarLivro("aaa", "RRR", "azsxdcfvgbhnj", vetorAutores, 100);
		// biblioteca.cadastrarLivro("bbb", "EEE", "1234567890133", vetorAutores, 10);
		// biblioteca.cadastrarLivro("ddd", "DDD", "12345678kwo23", vetorAutores, 1);
		// biblioteca.cadastrarLivro("ggg", "ASDA", "qwertyuiopasd", vetorAutores, 371);
		// biblioteca.cadastrarLivro("eee", "RRR", "azsxdcfv34tnj", vetorAutores, 100);
		// biblioteca.cadastrarLivro("fff", "TTT", "zaxscdvfbgnhm", vetorAutores, 1000);
		// biblioteca.cadastrarLivro("hhh", "EEE", "12317el890123", vetorAutores, 10);
		// biblioteca.cadastrarLivro("www", "Aaa", "6ucrgkf5x48kx", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("qqq", "Aaa", "5okj0tievkjtp", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("rrr", "Aaa", "6nfjbi9t0cu0l", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("AAA", "Aaa", "9tpqbp95z4jus", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("zzz", "Aaa", "0fojfyg6k5dhk", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("iii", "Aaa", "7rsx0si65f8a4", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("yyy", "JKL", "214qrt2ut3ez0", vetorAutores, 34);
		// biblioteca.cadastrarLivro("uuu", "Aaa", "9glvcf9ni3344", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ttt", "Aaa", "8tefolbsrjx69", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ooo", "Aaa", "4fdrokqyevfe6", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("jjj", "Aaa", "62xhjlxm7wyrn", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("nnn", "Aaa", "3wuei8iicfolc", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("vvv", "Aaa", "6hms47m3xnyy3", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("xxx", "Aaa", "859xpef1okkyw", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("zzz", "Aaa", "9h508dn4hb84e", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("kkk", "Aaa", "1z79lnkll3y6x", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("mmm", "JKL", "8tf4q04w1auyo", vetorAutores, 34);
		// biblioteca.cadastrarLivro("sss", "Aaa", "89qckebwgrmui", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ççç", "Aaa", "99elfxtdzrnf6", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("lll", "Aaa", "6r43boeny4nu0", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("asd", "Aaa", "18lhxysidgh1j", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("KKK", "Aaa", "57wjllggx1l8q", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("Zklj", "Aaa", "640bxw58wcpjr", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("BBB", "Aaa", "19hp0ylq4kcbh", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("RRR", "Aaa", "7v8i2w6s7c527", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("TTT", "JKL", "7dw40qxgqjv0j", vetorAutores, 34);
		// biblioteca.cadastrarLivro("EEE", "Aaa", "7bj1lrkcn07k9", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("WWW", "Aaa", "0ufz2ye4fbyoa", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("QQQ", "Aaa", "5257m1pr0zl4d", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("PPP", "Aaa", "0ch63vxvtv785", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("III", "Aaa", "7mco7cgwo6oie", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("UUU", "Aaa", "0md1ix4j02p6j", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("YYY", "Aaa", "5vi0fx650wwgk", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("TTT", "Aaa", "4hsqhvsshd8h6", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ppp", "Aaa", "9ggfm0f0riicv", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("MMM", "JKL", "7shrxwe99iy9t", vetorAutores, 34);
		// biblioteca.cadastrarLivro("JJJ", "Aaa", "8kjbzrxfdqmzq", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("OOO", "Aaa", "7qxenakhivgb5", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("SSS", "Aaa", "5wh5dq9l8bejs", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ZZZ", "Aaa", "0f266cqegkbe4", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("BBB", "Aaa", "5g2fjbe88d9yw", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("XXX", "Aaa", "30c1fe890aa3y", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("VVV", "Aaa", "5crrqkja2edza", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ttt", "Aaa", "5hyv0i4bibliotecahbkj", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("GGG", "Aaa", "89vrzu605gyqv", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("ÇÇÇ", "Aaa", "36xgu5a39017b", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("FFF", "Aaa", "5g2fjbe8ef9yw", vetorAutores, 1234);
		// biblioteca.cadastrarLivro("DDD", "Aaa", "joeudnwmso19w", vetorAutores, 1234);
		
		biblioteca.imprimeInformacoesUsuarios();		
		
		biblioteca.cadastrarUsuario("bbb", "1q2w3e4r5t6", "endereco", "telefone");
		// biblioteca.cadastrarUsuario("ccc", "1q2w3wrr5t6", "endereco", "telefone");
		// biblioteca.cadastrarUsuario("aaa", "1q2wjo4r5t6", "endereco", "telefone");
		// biblioteca.cadastrarUsuario("ddd", "qwertyuiop", "endereco", "telefone");
		// biblioteca.cadastrarUsuario("ccc", "123", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("aaa", "1234", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("bbb", "1235", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("ddd", "1236", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("ggg", "1237", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("eee", "1238", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("fff", "1239", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("hhh", "1230", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("www", "123a", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("qqq", "123z", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("rrr", "123s", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("AAA", "123x", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("zzz", "123w", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("iii", "123e", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("yyy", "123d", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("uuu", "123c", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("ttt", "123r", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("ooo", "123f", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("jjj", "123v", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("nnn", "123b", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("vvv", "123g", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("xxx", "123t", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("zzz", "123y", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("kkk", "123h", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("mmm", "123n", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("sss", "123m", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("ççç", "123j", "telefone", "endereco");
		// biblioteca.cadastrarUsuario("lll", "123u", "telefone", "endereco");
		
		
		
		biblioteca.ativarUsuario("1q2w3e4r5t6");
		
		biblioteca.emprestarLivro("1234567890123", "1q2w3e4r5t6");
		biblioteca.emprestarLivro("azsxdcfvgbhnj", "1q2w3e4r5t6");
		biblioteca.emprestarLivro("1234567890133", "1q2w3e4r5t6");
		biblioteca.emprestarLivro("1234567890123", "1q2w3e4r5t6");
		biblioteca.emprestarLivro("qwertyuiopasd", "1q2w3e4r5t6");

		biblioteca.imprimeInformacoesUsuarios();
		
		biblioteca.devolverLivro("1234567890123", "1q2w3e4r5t6");
		biblioteca.devolverLivro("azsxdcfvgbhnj", "1q2w3e4r5t6");
		biblioteca.devolverLivro("1234567890133", "1q2w3e4r5t6");
		biblioteca.devolverLivro("1234567890123", "1q2w3e4r5t6");
		biblioteca.devolverLivro("qwertyuiopasd", "1q2w3e4r5t6");

		
		
		biblioteca.imprimeInformacoesLivros();
	}
}