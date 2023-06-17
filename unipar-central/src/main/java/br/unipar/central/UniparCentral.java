package br.unipar.central;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntNaoInformadaException;
import br.unipar.central.exceptions.SaldoInsuficienteException;
import br.unipar.central.exceptions.TamanhoInvalidoException;
import br.unipar.central.exceptions.ValorInvalidoException;
import br.unipar.central.models.Agencia;
import br.unipar.central.models.Banco;
import br.unipar.central.models.Cidade;
import br.unipar.central.models.Conta;
import br.unipar.central.models.Endereco;
import br.unipar.central.models.Estado;
import br.unipar.central.models.Pais;
import br.unipar.central.models.Pessoa;
import br.unipar.central.models.PessoaFisica;
import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.models.Telefone;
import br.unipar.central.models.Transacao;
import br.unipar.central.services.AgenciaService;
import br.unipar.central.services.BancoService;
import br.unipar.central.services.CidadeService;
import br.unipar.central.services.ContaService;
import br.unipar.central.services.EnderecoService;
import br.unipar.central.services.EstadoService;
import br.unipar.central.services.PaisService;
import br.unipar.central.services.PessoaFisicaService;
import br.unipar.central.services.PessoaJuridicaService;
import br.unipar.central.services.PessoaService;
import br.unipar.central.services.TelefoneService;
import br.unipar.central.services.TransacaoService;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Formatter;
import java.util.List;

public class UniparCentral {

    public static void main(String[] args) throws SQLException, EntNaoInformadaException, TamanhoInvalidoException, CampoNaoInformadoException, ParseException, SaldoInsuficienteException, ValorInvalidoException {

//        PaisService servicePais = new PaisService();
//        Pais pais = new Pais();
//        pais.setId(9237841);
//        pais.setNome("Pais Teste RAC");
//        pais.setRa("96969");
//        pais.setSigla("RC");
//        servicePais.insert(pais);
//        servicePais.update(pais);



//        EstadoService serviceEstado = new EstadoService();
//        Estado estado = new Estado();
//        estado.setId(69);
//        estado.setNome("Estado Teste RAC");
//        estado.setPais(pais);
//        estado.setRa("00239539");
//        estado.setSigla("RC");
//        serviceEstado.insert(estado);
//        serviceEstado.update(estado);



//        CidadeService serviceCidade = new CidadeService();
//        Cidade cidade = new Cidade();
//        cidade.setId(6969);
//        cidade.setNome("Cidade Teste RAC");
//        cidade.setRa("00239539");
//        cidade.setEstado(estado); 
//        serviceCidade.insert(cidade);
//        serviceCidade.update(cidade);
//
//        PessoaService servicePessoa = new PessoaService();
//        Pessoa pessoa = new Pessoa();
//        pessoa.setId(100);
//        pessoa.setEmail("RafaelTeste22@gmail.com");
//        pessoa.setRa("00239539");
//        servicePessoa.validar(pessoa);
//        servicePessoa.update(pessoa);



//        PessoaJuridicaService servicePJ = new PessoaJuridicaService();
//        PessoaJuridica pessoaJ = new PessoaJuridica();
//        pessoaJ.setCnaePrincipal("43525");
//        pessoaJ.setCnpj("12345678999999");
//        pessoaJ.setFantasia("teste rafael");
//        pessoaJ.setRazaoSocial("Rafael Teste Cantu");
//        pessoaJ.setPessoa(pessoa);
//        servicePJ.insert(pessoaJ);
//        servicePJ.update(pessoaJ);
//
//        PessoaFisicaService servicePF = new PessoaFisicaService();
//        PessoaFisica pessoaFisica = new PessoaFisica();
//        pessoaFisica.setNome("Cantu Teste");
//        pessoaFisica.setRa("00239539");
//        pessoaFisica.setCpf("07818983353");
//        pessoaFisica.setDataNascimento(new Date(20030805));
//        pessoaFisica.setRg("1234567");
//        pessoaFisica.setPessoa(pessoa);
//        servicePF.insert(pessoaFisica);
//        servicePF.update(pessoaFisica);
//


//        TransacaoService serviceTransacao = new TransacaoService();
//        Transacao transacao = new Transacao();
//        transacao.setId(5542);
//        transacao.setContaDestino(new Conta(100));
//        transacao.setContaOrigem(new Conta(69));
//        transacao.setRa("00239539");
//        transacao.setValor(523);
//        transacao.setTipo(2);
//        serviceTransacao.insert(transacao);
//        serviceTransacao.update(transacao);



//        EnderecoService serviceEndereco = new EnderecoService();
//        Endereco endereco = new Endereco();
//        endereco.setBairro("Centro");
//        endereco.setCep("53434432");
//        endereco.setCidade(cidade);
//        endereco.setComplemento("ap 404");
//        endereco.setId(68855);
//        endereco.setNumero("323");
//        endereco.setPessoa(pessoa);
//        endereco.setRa("00239539");
//        endereco.setRua("Rua 5 de julho");  
//        serviceEndereco.insert(endereco);
//        serviceEndereco.update(endereco);
//
//        BancoService serviceBanco = new BancoService();
//        Banco banco = new Banco();
//        banco.setId(100);
//        banco.setNome("Banco Teste RAC");
//        banco.setRa("00239539");
//        serviceBanco.validar(banco);
//        serviceBanco.update(banco);



//        AgenciaService serviceAgencia = new AgenciaService();
//    Agencia agencia = new Agencia();
//    agencia.setBanco(banco);
//    agencia.setCnpj("99444495");
//    agencia.setCodigo("343");
//    agencia.setId(4124);
//    agencia.setRa("00239539");
//    agencia.setRazaoSocial("Rafael TESTES inc");
//    serviceAgencia.insert(agencia);
//    serviceAgencia.update(agencia);



//        TelefoneService serviceTelefone = new TelefoneService();
//    Telefone telefone = new Telefone();
//    telefone.setAgencia(agencia);
//    telefone.setId(45552);
//    telefone.setNumero("984848444");
//    telefone.setOperadora(2);
//    telefone.setPessoa(pessoa);
//    telefone.setRa("00239539");
//    serviceTelefone.insert(telefone);
//    serviceTelefone.update(telefone);



//        ContaService serviceConta = new ContaService();
//        Conta conta = new Conta();
//        conta.setAgencia(agencia);
//        conta.setDigito("5");
//        conta.setId(553453);
//        conta.setNumero("42");
//        conta.setPessoa(pessoa);
//        conta.setRa("00239539");
//        conta.setSaldo(444400);
//        conta.setTipo(2);
//        serviceConta.insert(conta);
//        serviceConta.update(conta);



//        List<Agencia> resultadoAgencia = serviceAgencia.findAll();
//        List<Banco> resultadoBanco =serviceBanco.findAll();
//        List<Conta> resultadoConta =serviceConta.findAll();
//        List<Endereco> resultadoEndereco =serviceEndereco.findAll();
//        List<Estado> resultadoEstado =serviceEstado.findAll();
//        List<PessoaFisica> resultadoPF =servicePF.findAll();
//        List<PessoaJuridica> resultadoPJ =servicePJ.findAll();
//        List<Pais> resultadoPais =servicePais.findAll();
//        List<Pessoa> resultadoPessoa =servicePessoa.findAll();
//        List<Telefone> resultadoTelefone =serviceTelefone.findAll();
//        List<Transacao> resultadoTransacao =serviceTransacao.findAll();
//        
//        System.out.println(resultadoAgencia.toString());
//        System.out.println(resultadoBanco.toString());
//        System.out.println(resultadoConta.toString());
//        System.out.println(resultadoEndereco.toString());
//        System.out.println(resultadoEstado.toString());
//        System.out.println(resultadoPF.toString());
//        System.out.println(resultadoPJ.toString());
//        System.out.println(resultadoPais.toString());
//        System.out.println(resultadoPessoa.toString());
//        System.out.println(resultadoTelefone.toString());
//        System.out.println(resultadoTransacao.toString());
    }
}
