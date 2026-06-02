package Proj;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Gerir_ocorrencia {
	private ArrayList<Ocorrencia> lista_correncias;
	private ArrayList<Utilizador> lista_utilizadores;
	private ArrayList<Categoria> lista_categoria;
	
	/**
	 * Construtor do gerir ocorrencia
	 */
	public Gerir_ocorrencia( ) {
		this.lista_correncias = new ArrayList<Ocorrencia>();
		this.lista_utilizadores = new ArrayList<Utilizador>();
		this.lista_categoria = new ArrayList<Categoria>();
	}
	
	/**
	 * @param nome
	 * @return 1 se encontrar se não 0
	 */
	public int existe_nome(String nome) {
		
		for(Utilizador u:lista_utilizadores) {
			if(u.getNome().equals(nome)) {
				return 1;
	
			}
			
		}
		return 0;
	}
	
	/**
	 * @param tipo numero 1=Admin, 2=Equipa, 3=Utilizador
	 * @return String com o tipo ou null
	 */
	public String existe_tipo_utilizador(int tipo) {
		if(tipo == 1) return "Admin";
		if(tipo == 2) return "Equipa";
		if(tipo == 3) return "Utilizador";
		return null;
	}
	
	/**
	 * @param uti
	 * Adiciona/cria utilizador á lista
	 */
	public void registar_utilizador(Utilizador uti) {
		lista_utilizadores.add(uti);
	}
	
	/**
	 * @param cat
	 * @return 1 se encontrar se não 0 ->procura categoria
	 */
	public int existe_categoria(String cat) {
		for(Categoria u:lista_categoria) {
			if(u.getNome().equals(cat)) {
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * @param o
	 * adiciona/cria ocorrencia
	 */
	public void registar_ocorrencia(Ocorrencia o) {
		lista_correncias.add(o);
	}
	
	/**
	 * @param titulo
	 * @return 1 se encontrar se não 0 ->procura titulo
	 */
	public int existe_ocorrencias(String titulo) {
		for(Utilizador u:lista_utilizadores) {
			for (Ocorrencia o:lista_correncias) {
				if(o.getTitulo().equals(titulo)) {
					return 1;
				}
			}
		}
		return 0;
		
		
	}
	
	/**
	 * @param tipo String do tipo de utilizador
	 * @return 1 se for Admin ou Equipa, senão 0
	 */
	public int ver_utilizador(String tipo) {
			if(tipo.equals("Admin")||tipo.equals("Equipa")) {
				return 1;
			}
			return 0;
		
	}
	
	/**
	 * @param estado
	 * @return 1 se encontrar se não 0->se alterar o estado para Em Processo ou Concluido
	 */
	public int existe_estado(String estado) {
		if(estado.equals("Em Processo")||estado.equals("Concluido")) {
			return 1;
		}
		return 0;
	}
	/**
	 * @param estado 1=Em Processo, 2=Concluido
	 * @return String do estado ou null se inválido
	 */
	public String transformar_estado(int estado) {
		if(estado == 1) return "Em Processo";
		if(estado == 2) return "Concluido";
		return null;
	}
	
	/**
	 * @param titulo_novo
	 * @param nome_utilizador
	 * @param titulo_original
	 * edita titulo
	 */
	public void editar_titulo_ocorrencia(String titulo_novo,String nome_utilizador,String titulo_original) {
		for(Utilizador u:lista_utilizadores) {
		for(Ocorrencia o:lista_correncias) {
				if(u.getNome().equals(nome_utilizador)) {
					if(o.getTitulo().equals(titulo_original)) {
						o.setTitulo(titulo_novo);
					}
				}
			}
		}
	}
	
	/**
	 * @param descricao
	 * @param nome_utilizador
	 * @param titulo_original
	 * edita descricao
	 */
	public void editar_descricao_ocorrencia(String descricao,String nome_utilizador,String titulo_original) {
		for(Utilizador u:lista_utilizadores) {
		for(Ocorrencia o:lista_correncias) {
				if(u.getNome().equals(nome_utilizador)) {
					if(o.getTitulo().equals(titulo_original)) {
						o.setDescricao(descricao);
					}
				}
			}
		}
	}
	
	
	
	/**
	 * @param localizacao
	 * @param nome_utilizador
	 * @param titulo_original
	 * edita localizacao
	 */
	public void editar_localizacao_ocorrencia(String localizacao,String nome_utilizador,String titulo_original) {
		for(Utilizador u:lista_utilizadores) {
		for(Ocorrencia o:lista_correncias) {
				if(u.getNome().equals(nome_utilizador)) {
					if(o.getTitulo().equals(titulo_original)) {
						o.setLocalizacao(localizacao);
					}
				}
			}
		}
	}
	
	/**
	 * @param nivel
	 * @param nome_utilizador
	 * @param titulo_original
	 * edita nivel
	 */
	public void editar_nivel_ocorrencia(int nivel,String nome_utilizador,String titulo_original) {
		for(Utilizador u:lista_utilizadores) {
		for(Ocorrencia o:lista_correncias) {
				if(u.getNome().equals(nome_utilizador)) {
					if(o.getTitulo().equals(titulo_original)) {
						o.setNivel_urgencia(nivel);
					}
				}
			}
		}
	}
	
	
	/**
	 * lista de todas as ocorrencias
	 */
	public void lista_ocorrencia_admin() {
		for(Ocorrencia o:lista_correncias) {
			System.out.println(o.toString());
		}
	}
	
	/**
	 * @param nome_login
	 * lista das ocorrencias criadas pelo utilizador
	 */
	public void lista_ocorrencia_utilizador(String nome_login) {
		for(Utilizador u:lista_utilizadores) {
				for(Ocorrencia o:lista_correncias) {
					if(o.getNome_autor().equals(nome_login)) {
						System.out.println(o.toString());
				}
			}
			
			}
	}
	
	
	/**
	 * @param titulo
	 * @param nome
	 * @return
	 * verifica se existe o titulo da ocorrencia num utilizador
	 */
	public int existe_titulo(String titulo,String nome) {
		
		for(Ocorrencia o:lista_correncias) {
			if(o.getNome_autor().equals(nome)) {
				if(o.getTitulo().equals(titulo)) {
					return 1;
				}
			}
		}
			
		
		return 0;
	}
	
	
	
	/**
	 * @param nome_login utilizador logado
	 * @param user tipo do utilizador
	 * @param titulo titulo da ocorrencia a ver
	 */
	public void lista_ver_detalhes(String nome_login, String user, String titulo) {
		for(Utilizador u:lista_utilizadores) {
			for(Ocorrencia o:lista_correncias) {
				if(o.getTitulo().equals(titulo)) {
					if(u.getTipo_utilizador().equals("Utilizador")) {
						o.detalhes();
					}else {
						o.detalhes();
					}
				}
			}
			
		}
	}
	
	
	/**
	 * @param nome_utilizador
	 * @param titulo
	 * @return
	 * exiete titulo no utilizador
	 */
	public int existe_titulo_utilizador(String nome_utilizador,String titulo) {
	
		for(Ocorrencia o:lista_correncias) {
			if(o.getNome_autor().equals(nome_utilizador)) {
				if(o.getTitulo().equals(titulo)) {
					return 1;
				}
			}
		}
		return 0;
		
	}
	
	/**
	 * @param titulo
	 * @param estado
	 * alterar estado
	 */
	public void alterar_estado(String titulo,String estado) {
		for(Ocorrencia o:lista_correncias) {
			if(o.getTitulo().equals(titulo)) {
				o.setEstado(estado);
			}
		}
	}
	
	
	/**
	 * @param titulo
	 * @param estado
	 * @param data
	 * quando da como concluida muda a data final
	 */
	public void alterar_estado_data(String titulo,String estado,LocalDate data) {
		for(Ocorrencia o:lista_correncias) {
			if(o.getTitulo().equals(titulo)) {
				o.setEstado(estado);
				o.setData_final(data);
			}
		}
	}
	
	
	/**
	 * @param categoria
	 * adiciona categoria
	 */
	public void registar_categoria(Categoria c) {
	    lista_categoria.add(c);
	}
	
	/**
	 * lista categorias
	 */
	public void lista_categorias() {
		for(Categoria c:lista_categoria) {
			System.out.println(c.getNome());
		}
	}
	
	/**
	 * @param utilizador
	 * @param titulo
	 * pesquisar titulo
	 */
	public void pesquisar_titulo_uti(String utilizador,String titulo) {
		int existe=0;
		for(Utilizador u:lista_utilizadores) {
			for(Ocorrencia o:lista_correncias) {
				if(u.getNome().equals(utilizador)) {
					if(o.getTitulo().equals(titulo)) {
						o.toString();
						existe=1;
					}
				}
			}
		}
		if(existe==0) {
			System.out.println("**************************************************************************************");
			System.out.println("*                                                                                    *");
       	System.out.println("*                  Não existe titulo / There is no title                             *");
       	System.out.println("*                                                                                    *");
       	System.out.println("**************************************************************************************");
		
		}
	}
	
	
	/**
	 * @param titulo
	 * pesquisar titulo equipa/admin
	 */
	public void pesquisar_titulo(String titulo) {
			int existe=0;
			for(Ocorrencia o:lista_correncias) {
					if(o.getTitulo().equals(titulo)) {
						o.toString();
						existe=1;
					}
				
			}
			if(existe==0) {
				System.out.println("**************************************************************************************");
				System.out.println("*                                                                                    *");
	        	System.out.println("*                  Não existe titulo / There is no title                             *");
	        	System.out.println("*                                                                                    *");
	        	System.out.println("**************************************************************************************");
			
			}
		
	}
	
	/**
	 * @param utilizador
	 * @param categoria
	 * pesquisar catgoria utilizador
	 */
	public void pesquisar_categoria_uti(String utilizador,String categoria) {
		int existe=0;
		for(Utilizador u:lista_utilizadores) {
			for(Ocorrencia o:lista_correncias) {
				if(u.getNome().equals(utilizador)) {
					if(o.getTitulo().equals(categoria)) {
						o.toString();
						existe=1;
					}
				}
			}
		}
		if(existe==0) {
			System.out.println("**************************************************************************************");
			System.out.println("*                                                                                    *");
       	System.out.println("*            Não existe categoria / There is no category                             *");
       	System.out.println("*                                                                                    *");
       	System.out.println("**************************************************************************************");
		
		}
	}
	
	/**
	 * @param categoria
	 * pesquisar categoria
	 */
	public void pesquisar_categoria(String categoria) {
		int existe =0;
		for(Ocorrencia o:lista_correncias) {
			if(o.getTitulo().equals(categoria)) {
				o.toString();
				existe=1;
			}
		}
		if(existe==0) {
			System.out.println("**************************************************************************************");
			System.out.println("*                                                                                    *");
       	System.out.println("*            Não existe categoria / There is no category                             *");
       	System.out.println("*                                                                                    *");
       	System.out.println("**************************************************************************************");
		
		}
	}
	
	
	/**
	 * @param titulo
	 * @return 1 se encontrar, senão 0
	 */
	public int existe_titulo(String titulo) {
		for(Ocorrencia o:lista_correncias) {
			if(o.getTitulo().equals(titulo)) {
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * @param mes
	 * filtrar mes
	 */
	public void filtrar_mes(int mes) {
		if(mes>=1 && mes<=12) {	
			for(Ocorrencia o:lista_correncias) {
				if(o.getData_inicial().getMonthValue()==mes) {
					System.out.println(o.toString());
				}
			}
		}else {
			System.out.println("**************************************************************************************");
			System.out.println("*                                                                                    *");
       	System.out.println("*                                Mes iválido / Invalid month                         *");
       	System.out.println("*                                                                                    *");
       	System.out.println("**************************************************************************************");
		}
	}
	
	/**
	 * @param ano
	 * filtrar ano
	 */
	public void filtrar_ano(int ano) {
		if(ano>=2000 && ano<=2100) {	
			for(Ocorrencia o:lista_correncias) {
				if(o.getData_inicial().getYear()==ano) {
					System.out.println(o.toString());
				}
			}
		}else {
			System.out.println("**************************************************************************************");
			System.out.println("*                                                                                    *");
       	System.out.println("*                                Ano iválido / Invalid year                          *");
       	System.out.println("*                                                                                    *");
       	System.out.println("**************************************************************************************");
		}
	}
	
	/**
	 * @param nome_utilizador
	 * @param titulo
	 * elimina ocorrencia do utilizador
	 */
	public int eliminar_ocorrencia(String nome_utilizador, String titulo) {
	    for (int i = 0; i < lista_correncias.size(); i++) {
	        Ocorrencia o = lista_correncias.get(i);
	        if (o.getNome_autor().equals(nome_utilizador) && o.getTitulo().equals(titulo)) {
	            lista_correncias.remove(i);
	            return 1; // eliminado com sucesso
	        }
	    }
	    return 0; // não encontrou nada
	}
	
}
