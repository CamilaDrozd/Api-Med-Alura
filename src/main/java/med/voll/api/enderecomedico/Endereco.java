package med.voll.api.enderecomedico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

        public Endereco(DadosEndereco info) {
        this.logradouro = info.logradouro();
        this.bairro = info.bairro();
        this.cep = info.cep();
        this.uf = info.uf();
        this.cidade = info.cidade();
        this.numero = info.numero();
        this.complemento = info.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null){
          this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }
    }
}
