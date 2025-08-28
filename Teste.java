import org.junit.jupiter.api.Test;

class Teste {
	
	@Test
	void test() {
		
		SalaAula engenharia = new SalaAula();
		engenharia.addAluno(new Aluno("joao", "123"));
		
		assertEquals(engenharia.getAlunos().size(), 1)
	}
}
