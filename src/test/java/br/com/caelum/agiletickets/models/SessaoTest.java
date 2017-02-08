package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	// Ingresso Disponível > Reserva Solicitadas
	@Test
<<<<<<< HEAD
	public void deveVenderIgressosSeHaVagasDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	// Ingresso Disponivel < Reserva Solicitada
	@Test
	public void naoDeveVenderMaisIngressosSeNaoHaVagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
=======
	public void deveVenderIngressosDisponiveisQuandoReservadoTodos() {
		final Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);
		
		Assert.assertTrue(sessao.podeReservar(2));
	}
	
	@Test
	public void deveVenderIngressosDisponiveisQuandoReservadoMenosQueDisponivel() {
		final Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(2));
	}
	
	@Test
	public void naoDeveVenderIngressosDisponiveisQuandoReservadoMaisQueDisponivel() {
		final Sessao sessao = new Sessao();
		sessao.setTotalIngressos(1);
		
		Assert.assertFalse(sessao.podeReservar(2));
>>>>>>> 0f24454d8feff41a2aa6b88d19ce3bd4f32598ed
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarParametroIlegalQuandoReservadoNenhum() {
		final Sessao sessao = new Sessao();
		sessao.setTotalIngressos(1);
		
		Assert.assertFalse(sessao.podeReservar(0));
	}
	
	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	// Ingresso Disponivel = Reserva Solicitada
	@Test
	public void deveVenderTodosIngressosSeHaVagasDisponiveis(){
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);
		
		Assert.assertTrue(sessao.podeReservar(2));
	}
	
}
