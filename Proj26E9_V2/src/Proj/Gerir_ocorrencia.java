package Proj;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Gerir_ocorrencia {
	private ArrayList<Ocorrencia> lista_correncias;
	private ArrayList<Utilizador> lista_utilizadores;
	private ArrayList<Categoria> lista_categoria;
	private ArrayList<Equipa> lista_equipas;
	private ArrayList<Denuncia>denuncias;
	private ArrayList<Localizacao> lista_localizacoes;
	
	/**
	 * Construtor do gerir ocorrencia
	 */
	public Gerir_ocorrencia( ) {
		this.lista_correncias = new ArrayList<Ocorrencia>();
		this.lista_utilizadores = new ArrayList<Utilizador>();
		this.lista_categoria = new ArrayList<Categoria>();
		this.lista_equipas = new ArrayList<Equipa>();
		this.denuncias = new ArrayList<Denuncia>();
		this.lista_localizacoes = new ArrayList<Localizacao>();
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
		for (Ocorrencia o : lista_correncias) {
			if (o.getTitulo().equals(titulo)) {
				return 1;
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
		for(Ocorrencia o:lista_correncias) {
			if(o.getNome_autor().equals(nome_login)) {
				System.out.println(o.toString());
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
	 * @param nomeEquipa nome da equipa (usado quando user é Equipa)
	 */
	public void lista_ver_detalhes(String nome_login, String user, String titulo, String nomeEquipa) {
		for (Ocorrencia o : lista_correncias) {
			if (o.getTitulo().equals(titulo)) {
				if (user.equals("Admin")) {
					System.out.println(o.detalhes());
					return;
				} else if (user.equals("Equipa")) {
					if (o.getNomeEquipaAtribuida().equals(nomeEquipa)) {
						System.out.println(o.detalhes());
					} else {
						System.out.println("**************************************************************************************");
						System.out.println("*                                                                                    *");
						System.out.println("*         Sem permissao para ver esta ocorrencia / No permission to view this        *");
						System.out.println("*                                                                                    *");
						System.out.println("**************************************************************************************");
					}
					return;
				} else {
					if (o.getNome_autor().equals(nome_login)) {
						System.out.println(o.detalhes());
					} else {
						System.out.println("**************************************************************************************");
						System.out.println("*                                                                                    *");
						System.out.println("*         Sem permissao para ver esta ocorrencia / No permission to view this        *");
						System.out.println("*                                                                                    *");
						System.out.println("**************************************************************************************");
					}
					return;
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
						System.out.println(o.toString());
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
						System.out.println(o.toString());
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
					if(o.getCategoria().equals(categoria)) {
						System.out.println(o.toString());
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
			if(o.getCategoria().equals(categoria)) {
				System.out.println(o.toString());
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
	 * @param nome
	 * criar equipa
	 */
	public void criar_equipa(Equipa criar) {
	    lista_equipas.add(criar);
	}
	
	
	/**
	 * @param nome,  categoria
	 * verifica se ja existe equipa com a mesma categoria e o mesmo nome 
	 */
	public int existe_equipa(String categoria,String nome) {
	    for(Categoria c:lista_categoria) {
	    	if(c.getNome().equals(categoria)){
		    	for(Equipa e:lista_equipas) {
		    		if(e.getNome().equals(nome)) {
		    			return 1;
		    		}
		    	}
	    	}	
	    }
	    return 0;
	}
	
	

	
	/**
	 * @param u
	 * @param equipa
	 * @return
	 * adiciona membro a uma equipa 
	 */
	public int adicionarMembro(Utilizador u, Equipa equipa) {
        for (Utilizador membro : lista_utilizadores) {
            if (membro.getNome().equals(u.getNome())) {
                for (Equipa equipaDaLista : lista_equipas) {
                    if (equipaDaLista.getNome().equals(equipa.getNome()) && equipaDaLista.getCategoria().equals(equipa.getCategoria())) {
                        
                        if (equipaDaLista.getLotacao() > equipaDaLista.getLotacao_ocupada()) {
                            equipaDaLista.adicionarMembro(u); 
                            equipaDaLista.setLotacao_ocupada(equipaDaLista.getLotacao_ocupada() + 1);
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
        return 0;
    }

	
	/**
	 * @param nome_utilizador
	 * @param titulo
	 * elimina ocorrencia do utilizador
	 */
	
	public int eliminar_ocorrencia(String nome_utilizador, String titulo) {
	    for (Ocorrencia o:lista_correncias) {
	        if (o.getNome_autor().equals(nome_utilizador) && o.getTitulo().equals(titulo)) {
	            lista_correncias.remove(o);
	            return 1; 
	        }
	    }
	    return 0; 
	}
	
	
	/**
	 * @param nomeEquipa
	 * @param categoria
	 * @param porque
	 * @return
	 * eleminar equipa
	 */
	public int eliminar_equipa(String nomeEquipa, String categoria, String porque) {

	    if (nomeEquipa.trim().isEmpty() || categoria.trim().isEmpty() || porque.trim().isEmpty()) {
	        System.out.println("Todos os campos tem de ser preenchidos obrigatoriamente!");
	        return 0;
	    }

	    if (this.existe_categoria(categoria) == 0) {
	        System.out.println("A categoria '" + categoria + "' nao existe.");
	        return 0;
	    }

	    // Localiza a equipa pelo nome e categoria
	    Equipa equipaAlvo = null;
	    for (Equipa e : lista_equipas) {
	        if (e.getNome().equals(nomeEquipa) && e.getCategoria().equals(categoria)) {
	            equipaAlvo = e;
	            break;
	        }
	    }

	    if (equipaAlvo == null) {
	        System.out.println("A equipa '" + nomeEquipa + "' nao existe na categoria '" + categoria + "'.");
	        return 0;
	    }

	    // CORRECAO: desatribui as ocorrencias pendentes desta equipa para que nao fiquem orfas
	    for (Ocorrencia o : lista_correncias) {
	        if (o.getNomeEquipaAtribuida().equals(nomeEquipa) && !o.getEstado().equals("Concluido")) {
	            o.setNomeEquipaAtribuida("Nenhuma");
	        }
	    }

	    // CORRECAO: remove a equipa da lista de equipas
	    lista_equipas.remove(equipaAlvo);
	    return 1;
	}
	
	
	/**
	 * @param nomeEquipa
	 * @param categoria
	 * @param nomeMembro
	 * @param porque
	 * @return
	 * elemina membro
	 */
	public int eliminar_membro_criterio(String nomeEquipa, String categoria, String nomeMembro, String porque) {

	    if (nomeEquipa.trim().isEmpty() || categoria.trim().isEmpty() ||
	        nomeMembro.trim().isEmpty() || porque.trim().isEmpty()) {
	        System.out.println("Todos os campos tem de ser preenchidos obrigatoriamente!");
	        return 0;
	    }

	    if (this.existe_categoria(categoria) == 0) {
	        System.out.println("A categoria '" + categoria + "' nao existe.");
	        return 0;
	    }

	    // CORRECAO: procura a equipa na lista_equipas (nao em lista_utilizadores)
	    Equipa equipaAlvo = null;
	    for (Equipa e : lista_equipas) {
	        if (e.getNome().equals(nomeEquipa) && e.getCategoria().equals(categoria)) {
	            equipaAlvo = e;
	            break;
	        }
	    }

	    if (equipaAlvo == null) {
	        System.out.println("A equipa '" + nomeEquipa + "' nao existe na categoria '" + categoria + "'.");
	        return 0;
	    }

	    // CORRECAO: remove o membro da lista membros da equipa (nao da lista_utilizadores global)
	    ArrayList<Utilizador> membros = equipaAlvo.getMembros();
	    for (int i = 0; i < membros.size(); i++) {
	        if (membros.get(i).getNome().equals(nomeMembro)) {
	            membros.remove(i);
	            // CORRECAO: decrementa a lotacao ocupada da equipa
	            equipaAlvo.setLotacao_ocupada(equipaAlvo.getLotacao_ocupada() - 1);
	            return 1;
	        }
	    }
	    System.out.println("O membro '" + nomeMembro + "' nao foi encontrado na equipa '" + nomeEquipa + "'.");
	    return 0;
	}
	
	
	/**
	 * @param titulo
	 * @return 1 se a ocorrencia existe e tem equipa atribuida, senao 0
	 * CORRECAO: usado para validar denuncias de trabalho
	 */
	public int existe_titulo_com_equipa(String titulo) {
	    for (Ocorrencia o : lista_correncias) {
	        if (o.getTitulo().equals(titulo)) {
	            if (!o.getNomeEquipaAtribuida().equals("Nenhuma")) {
	                return 1;
	            }
	            return 0; // existe mas sem equipa
	        }
	    }
	    return 0;
	}


	/**
	 * @param d
	 * registar denuncia 
	 */
	public void registar_denuncia(Denuncia d) {
	    denuncias.add(d);
	}
	
	
	/**
	 * listar denuncia
	 */
	public void listar_denuncias() {
	    for (Denuncia d : denuncias) {
	        System.out.println(d.toString());
	    }
	}
	
	
	/**
	 * @return
	 * total_denuncias
	 */
	public int total_denuncias_equipa() {
		int total=0;
		for(Denuncia d :denuncias) {
			if(d.getTipo().equals("EQUIPA")) {
				total++;
			}
		}
		return total;
	}
	
	
	/**
	 * @return
	 * total de denuncias ocorrencia
	 */
	public int total_denuncias_ocorrencias() {
		int total=0;
		for(Denuncia d :denuncias) {
			if(d.getTipo().equals("OCORRENCIA")) {
				total++;
			}
		}
		return total;
	}
	
	/**
	 * @param novaOcorrencia
	 * atribuir trabalhos
	 */
	public void atribuir_trabalho(Ocorrencia novaOcorrencia) {
	    Equipa equipaComMenosTrabalho = null;
	    int menorNumeroDeTrabalhos = 999999;

	    for (Equipa e : lista_equipas) {
	        if (e.getCategoria().equals(novaOcorrencia.getCategoria())) {
	            int contagemTrabalhos = 0;
	            for (Ocorrencia o : lista_correncias) {
	                // Excluir a própria ocorrência e as já concluídas
	                if (o != novaOcorrencia &&
	                    o.getNomeEquipaAtribuida().equals(e.getNome()) &&
	                    !o.getEstado().equals("Concluido")) {
	                    contagemTrabalhos++;
	                }
	            }
	            if (contagemTrabalhos < menorNumeroDeTrabalhos) {
	                menorNumeroDeTrabalhos = contagemTrabalhos;
	                equipaComMenosTrabalho = e;
	            }
	        }
	    }

	    if (equipaComMenosTrabalho != null) {
	        novaOcorrencia.setNomeEquipaAtribuida(equipaComMenosTrabalho.getNome());
	        System.out.println("Trabalho atribuido a equipa: " + equipaComMenosTrabalho.getNome());
	    } else {
	        System.out.println("Nao ha nenhuma equipa desta categoria disponivel.");
	    }
	}

	/**
	 * @param nomeEquipa
	 * lista ocorrencias
	 */
	public void lista_ocorrencia_equipa(String nomeEquipa) {
	    if (nomeEquipa == null) {
	        System.out.println("Equipa não definida. Por favor volte a fazer login e selecione a sua equipa.");
	        return;
	    }
	    int encontrou = 0;
	    for (Ocorrencia o : lista_correncias) {
	        if (o.getNomeEquipaAtribuida().equals(nomeEquipa)) {
	            System.out.println(o.toString());
	            encontrou = 1;
	        }
	    }
	    if (encontrou == 0) {
	        System.out.println("A sua equipa nao tem trabalhos atribuidos de momento.");
	    }
	}
	
	/**
	 * lista as equipas
	 */
	public void listar_equipas() {
		for(Equipa e:lista_equipas) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * @param nomeEquipa
	 * @param categoria
	 * @param mes
	 * filtrar por mes ,  a equipa
	 */
	public void filtrar_mes_equipa_categoria(String nomeEquipa, String categoria, int mes) {
	    if (mes >= 1 && mes <= 12) {
	        for (Ocorrencia o : lista_correncias) {
	            if (o.getNomeEquipaAtribuida().equals(nomeEquipa) && o.getCategoria().equals(categoria) && o.getData_inicial().getMonthValue() == mes) {
	                System.out.println(o.toString());
	            }
	        }
	    } else {
	        System.out.println("**************************************************************************************");
	        System.out.println("*                                                                                    *");
	        System.out.println("*                     Mes invalido / Invalid month                                   *");
	        System.out.println("*                                                                                    *");
	        System.out.println("**************************************************************************************");
	    }
	}

	/**
	 * @param nomeEquipa
	 * @param categoria
	 * @param ano
	 * filtrar por ano, a equipa
	 */
	public void filtrar_ano_equipa_categoria(String nomeEquipa, String categoria, int ano) {
	    if (ano >= 2000 && ano <= 2100) {
	        for (Ocorrencia o : lista_correncias) {
	            if (o.getNomeEquipaAtribuida().equals(nomeEquipa) && o.getCategoria().equals(categoria) && o.getData_inicial().getYear() == ano) {
	                System.out.println(o.toString());
	            }
	        }
	    } else {
	        System.out.println("**************************************************************************************");
	        System.out.println("*                                                                                    *");
	        System.out.println("*                         Ano invalido / Invalid year                                *");
	        System.out.println("*                                                                                    *");
	        System.out.println("**************************************************************************************");
	    }
	}
	
	/**
	 * @param piso
	 * @param sala
	 * verifica sala para os edificios menos o sao tome
	 */
	public  void verificarSala(int piso, int sala) {

	    int min = piso * 100;
	    int max = min + 21;

	    if (piso >= 1 && piso <= 6 && sala >= min && sala <= max) {
	        System.out.println("Sala válida no piso " + piso);
	    } else {
	        System.out.println("Sala inválida");
	    }
	}
		
		/**
		 * @param l
		 * regista localizacao
		 */
		public void registar_Loc(Localizacao l) {
			lista_localizacoes.add(l);
		}
		
		/**
		 * @param sala
		 * verifica sala para sao tome
		 */
		public void verificarSalaSaoTome(int sala) {

		    if (sala >= 700 && sala <= 721) {
		        System.out.println("Sala válida no São Tomé");
		    } else {
		        System.out.println("Sala inválida no São Tomé");
		    }
		}
	
}