package med.voll.api.pacientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enderecomedico.DadosEndereco;
import med.voll.api.enderecopaciente.EnderecoPaciente;

@Table(name = "paciente")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private EnderecoPaciente endereco;

    private Boolean ativo;
    public Paciente(DadosCadastroPacientes dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new EnderecoPaciente(dados.endereco());
    }


    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.dadosEndereco() != null){
            this.endereco.atualizarInformacoesPaciente(dados.dadosEndereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
