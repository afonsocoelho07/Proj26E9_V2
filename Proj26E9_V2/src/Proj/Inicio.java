package Proj;
import java.util.Scanner;
import java.time.LocalDate;
public class Inicio {
	public static void main(String[] args) {
		Gerir_ocorrencia metedos = new Gerir_ocorrencia();
		Scanner ler = new Scanner(System.in);
		int escolha_menu_1;
		int escolha_menu_2 = 0;
		do {
			System.out.println("**************************************************************************************");
			System.out.println("*           __      __    ________    _________         * Grupo 9 -> PL1             *");
			System.out.println("*          |  |    |  |  /   ___  \\  /         \\        * Afonso Gomes -> 53579      *");
			System.out.println("*          |  |    |  |  |  |   | |  \\__     __/        * Afonso Coelho -> 53706     *");
			System.out.println("*          |  |    |  |  |  |___| |     |   |           * Afonso Santos -> 53574     *");
			System.out.println("*          |  |    |  |  |  ______|     |   |           * Bernardo Carvalho -> 53697 *");
			System.out.println("*          |  |    |  |  |  |           |   |           * Diogo Cardoso -> 54039     *");
			System.out.println("*          \\  \\____/  /  |  |           |   |          *******************************");
			System.out.println("*           \\________/   |__|           |___|                                        *");
			System.out.println("*                                                                                    *");
			System.out.println("**************************************************************************************");
			System.out.println("*        1-Registar Utilizador/Register User                                         *");
			System.out.println("*        2-Login                                                                     *");
			System.out.println("*        3-Sair/Leave                                                                *");
			System.out.println("**************************************************************************************");
			System.out.println("*                                                                                    *");
			System.out.print("* Opcao/Option: ");
			escolha_menu_1 = ler.nextInt();
			System.out.println("*                                                                                    *");
			System.out.println("**************************************************************************************");
			ler.nextLine();
			// registar
			if (escolha_menu_1 == 1) {
				System.out.println("*                                                                                    *");
				System.out.print("*      Nome Utilizador a registar/Username to register : ");
				String nome_registar = ler.nextLine();
				if (metedos.existe_nome(nome_registar) == 1) {
					System.out.println("**************************************************************************************");
					System.out.println("*                                                                                    *");
					System.out.println("*            O utilizador já existe/The user already exists                          *");
					System.out.println("*                                                                                    *");
				} else {
					System.out.println("*                                                                                    *");
					System.out.print("* Tipo Utilizador a registar/User type to register (1-Admin/2-Equipa/3-Utilizador) : ");
					int tipo_registar = ler.nextInt();
					ler.nextLine();
					System.out.println("*                                                                                    *");
					
					String tipo_nome = metedos.existe_tipo_utilizador(tipo_registar);
					if (tipo_nome != null) {
						Utilizador uti = new Utilizador(nome_registar, tipo_nome);
						metedos.registar_utilizador(uti);
						System.out.println("**************************************************************************************");
						System.out.println("*                                                                                    *");
						
						System.out.println("* Utilizador Criado com sucesso como: " + tipo_nome);
						System.out.println("* User Successfully created as: " + tipo_nome);
						System.out.println("*                                                                                    *");
					} else {
						System.out.println("*                                                                                    *");
						System.out.println("*                             Invalido/Invalid                                       *");
						System.out.println("*                                                                                    *");
					}
				}
			// login
			} else if (escolha_menu_1 == 2) {
				System.out.println("*                                                                                    *");
				System.out.print("*                      Nome Utilizador/Username :  ");
				String nome_login = ler.nextLine();
				System.out.println("*                                                                                    *");
				if (metedos.existe_nome(nome_login) == 1) {
					System.out.println("*                                                                                    *");
					System.out.print("* Tipo Utilizador/User type  (1-Admin/2-Equipa/3-Utilizador) : ");
					int tipo_login = ler.nextInt();
					System.out.println("*                                                                                    *");
					ler.nextLine();
					String user = metedos.existe_tipo_utilizador(tipo_login);
					if (user != null) {
						
						// Bloco de entrada/registo em equipa - executado apenas uma vez após login
						String nome_equipa_entrar = null;
						String nome_categoria_entrar = null;
						
						if (user.equals("Equipa")) {
							System.out.println("**************************************************************************************");
							System.out.println("*                                                                                    *");
							System.out.println("*        1-Entrar numa equipa/Join a team                                            *");
							System.out.println("*        2-Registar-me numa equipa/ Register me for a team                           *");
							System.out.println("*                                                                                    *");
							System.out.println("**************************************************************************************");
							System.out.println("*                                                                                    *");
							System.out.print("* Opcao/Option: ");
							int opcao_equipa = ler.nextInt();
							ler.nextLine();
							System.out.println("*                                                                                    *");
							System.out.println("**************************************************************************************");
							
							if (opcao_equipa == 1) {
								System.out.println("*                                                                                    *");
								System.out.print("* Categoria da equipa/Team category: ");
								nome_categoria_entrar = ler.nextLine();
								System.out.println("*                                                                                    *");
								
								if (metedos.existe_categoria(nome_categoria_entrar) == 1) {
									System.out.print("* Nome da equipa/Team name: ");
									nome_equipa_entrar = ler.nextLine();
									System.out.println("*                                                                                    *");
									
									if (metedos.existe_equipa(nome_categoria_entrar, nome_equipa_entrar) == 1) {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*            Entrou na equipa " + nome_equipa_entrar + "                             *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                             Invalido/Invalid                                       *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										continue;
									}
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                             Invalido/Invalid                                       *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
									continue;
								}
								
							} else if (opcao_equipa == 2) {
								System.out.println("*                                                                                    *");
								System.out.print("* Categoria da equipa/Team category: ");
								String nome_categoria_registar = ler.nextLine();
								System.out.println("*                                                                                    *");
								
								if (metedos.existe_categoria(nome_categoria_registar) == 1) {
									System.out.print("* Nome da equipa/Team name: ");
									String nome_equipa_registar = ler.nextLine();
									System.out.println("*                                                                                    *");
									
									Utilizador uti = new Utilizador(nome_login, "Equipa");
									Equipa e = new Equipa(nome_equipa_registar, nome_categoria_registar, 0, 0);
									
									if (metedos.adicionarMembro(uti, e) == 1) {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                      Criado com sucesso/Successfully created                       *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										nome_equipa_entrar = nome_equipa_registar;
										nome_categoria_entrar = nome_categoria_registar;
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                       Não foi criado/It was not created                            *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										continue;
									}
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                             Invalido/Invalid                                       *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
									continue;
								}
							} else {
								System.out.println("**************************************************************************************");
								System.out.println("*                                                                                    *");
								System.out.println("*                             Invalido/Invalid                                       *");
								System.out.println("*                                                                                    *");
								System.out.println("**************************************************************************************");
								continue;
							}
						}
						
						// Segundo menu
						do {
							System.out.println("**************************************************************************************");
							System.out.println("*           __      __    ________    _________         * Grupo 9 -> PL1             *");
							System.out.println("*          |  |    |  |  /   ___  \\  /         \\        * Afonso Gomes -> 53579      *");
							System.out.println("*          |  |    |  |  |  |   | |  \\__     __/        * Afonso Coelho -> 53706     *");
							System.out.println("*          |  |    |  |  |  |___| |     |   |           * Afonso Santos -> 53574     *");
							System.out.println("*          |  |    |  |  |  ______|     |   |           * Bernardo Carvalho -> 53697 *");
							System.out.println("*          |  |    |  |  |  |           |   |           * Diogo Cardoso -> 54039     *");
							System.out.println("*          \\  \\____/  /  |  |           |   |          *******************************");
							System.out.println("*           \\________/   |__|           |___|                                        *");
							System.out.println("*                                                                                    *");
							System.out.println("**************************************************************************************");
							
							
							if (user.equals("Utilizador")) {
								System.out.println("*        1-Criar Ocorrencia/Create Incident                                          *");
								System.out.println("*        2-Eleminar Ocorrencia/Eliminate occurrence                                  *");
								System.out.println("*        3-Denunciar equipa/Report team                                              *");
								System.out.println("*        4-Denunciar trabalho/Report job                                             *");
								
							}

							System.out.println("*        5-Ver detalhes/View Details                                                 *");
							System.out.println("*        6-Lista Ocorrencias/List of Occurrences                                     *");
							System.out.println("*        7-Editar Ocorrencia/Edit Occurrence                                         *");
							System.out.println("*        8-Lista Categorias/List categories                                          *");
							
							
							if(user.equals("Admin")) {
								System.out.println("*        9-Criar Categoria/Create Category                                           *");
								System.out.println("*        10-Criar Equipa/Create Team                                                 *");
								System.out.println("*        11-Eleminar Membro/Delete Member                                            *");
								System.out.println("*        12-Eleminar Equipa/Delete Team                                              *");
								System.out.println("*        13-Denuncia Lista/Report list                                               *");
								System.out.println("*        14-Listar Equipas/List Teams                                                *");
							}else if (user.equals("Equipa") || user.equals("Admin")) {
								
								System.out.println("*        15-Filtrar mes/ano /Filter by month/year                                *");
							}
							
							System.out.println("*        16-Logout                                                                   *");
							System.out.println("**************************************************************************************");
							System.out.println("*                                                                                    *");
							System.out.print("* Opcao/Option: ");
							escolha_menu_2 = ler.nextInt();
							System.out.println("*                                                                                    *");
							System.out.println("**************************************************************************************");
							ler.nextLine();
							switch (escolha_menu_2) {
							// criar ocorrencia
							case 1:
								if (user.equals("Utilizador")) {
									System.out.println("*                                                                                    *");
									System.out.print("* Categoria Ocorrencia/Category Occurrence : ");
									String categoria = ler.nextLine();
									if (metedos.existe_categoria(categoria) == 1) {
										System.out.println("*                                                                                    *");
										System.out.print("* Título Ocorrencia/Title Occurrence : ");
										String titulo_ocorrencia = ler.nextLine();
										System.out.println("*                                                                                    *");
										System.out.print("* Descrição Ocorrencia/Description Occurrence : ");
										String descricao_ocorrencia = ler.nextLine();
										LocalDate data_inicio = LocalDate.now();
										System.out.println("*                                                                                    *");
																		
										System.out.println("*                                                                                    *");
										System.out.println("* Escolher Edificio/Choose Building : ");
										System.out.println("* Principal-1 Parque de Estacionamento-2 Sao tome-3 Espelho D'agua-4 Jardim-5 ");
										System.out.println("*                                                                                    *");
										Localizacao c = null;
										int escolher_Edificio = ler.nextInt();

										
										/// 1-edificio
										System.out.println("*************************************************************************************");										
										if (escolher_Edificio == 1) {

											System.out.println("*                                                                                    *");
										    System.out.print("Escolher o piso (1 a 6): ");
										    int escolher_Piso = ler.nextInt();
										    String edificio = "Principal";
											System.out.println("*                                                                                    *");
										    
										    switch (escolher_Piso) {

										        case 1: // piso 1
										        	System.out.println("*                                                                                    *");
										            System.out.print("Escolher Salas 1 / Outros 2: ");
										            int escolher_tipo = ler.nextInt();

										            if (escolher_tipo == 1) {
										            	System.out.println("*                                                                                    *");
										                System.out.print("*  Escolher Sala: ");
										                int escolher_sala = ler.nextInt();
										                System.out.println("*                                                                                    *");
										                metedos.verificarSala(escolher_Piso, escolher_sala);
										                c = new Localizacao(edificio,escolher_Piso, "Sala ", escolher_sala) ;

										            } else if (escolher_tipo == 2) {
										            	System.out.println("*                                                                                    *");
										                System.out.print("*  Biblioteca-1, Magna-2, Secretaria-3, WC-4, Corredor-5: ");
										                int escolher_outros = ler.nextInt();
										                System.out.println("*                                                                                    *");

										                String Localfinal = "";

										                if (escolher_outros == 1) {
										                    Localfinal = "Biblioteca";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 2) {
										                    Localfinal = "Magna";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 3) {
										                    Localfinal = "Secretaria";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 4) {
										                    Localfinal = "WC";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 5) {
										                    Localfinal = "Corredor";   
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else {
										                	System.out.println("*                                                                                    *");
										                    System.out.println("*                  Opção inválida/Invalid Option                                     *");
										                    System.out.println("*                                                                                    *");
										                }

										                
										            }
										            break;

										        case 2: //piso 2 
										        	System.out.println("*                                                                                    *");
										            System.out.println("*                   Piso 2 selecionado                                               *");
										            System.out.println("*                                                                                    *");
										            System.out.println("*               Escolher Salas 1 / Outros 2: ");
										            int escolher_tipo2 = ler.nextInt();

										            if (escolher_tipo2 == 1) {

										                System.out.print("Escolher Sala: ");
										                int escolher_sala = ler.nextInt();

										                metedos.verificarSala(escolher_Piso, escolher_sala);
										                c = new Localizacao(edificio,escolher_Piso, "Sala ", escolher_sala) ;

										            } else if (escolher_tipo2 == 2) {
										            	System.out.println("*                                                                                    *");
										                System.out.print("WC-1, Bar-2, Sala de Convivio-3, Gabinete De ingresso-4, Corredor-5 : ");
										                int escolher_outros = ler.nextInt();

										                String Localfinal = "";

										                if (escolher_outros == 1) {
										                    Localfinal = "WC";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 2) {
										                    Localfinal = "Bar";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 3) {
										                    Localfinal = "Convivio";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 4) {
										                    Localfinal = "Gabinete De ingresso";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 5) {
										                    Localfinal = "Corredor";    
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else {
										                	System.out.println("*                                                                                    *");
										                    System.out.println("*                     Opção inválida/Invalid Option                                  *");
										                    System.out.println("*                                                                                    *");
										                }
										            }
										            break;

										        case 3: //piso 3 
										        	System.out.println("*                                                                                    *");
										            System.out.println("*                        Piso 3 selecionado                                          *");
										            System.out.println("*                                                                                    *");
										            System.out.println("*    Escolher Salas 1 / Outros 2: ");
										            int escolher_tipo3 = ler.nextInt();

										            if (escolher_tipo3 == 1) {
										            	System.out.println("*                                                                                    *");
										                System.out.print("Escolher Sala: ");
										                int escolher_sala = ler.nextInt();

										                metedos.verificarSala(escolher_Piso, escolher_sala);
										                c = new Localizacao(edificio,escolher_Piso, "Sala ", escolher_sala) ;

										            } else if (escolher_tipo3 == 2) {
										            	System.out.println("*                                                                                    *");
										                System.out.print("WC-1 , Corredor-2, Mesas de Convívio-3 : ");
										                int escolher_outros = ler.nextInt();

										                String Localfinal = "";

										                if (escolher_outros == 1) {
										                    Localfinal = "WC";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 2) {
										                    Localfinal = "Corredor";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else if (escolher_outros == 3) {
										                    Localfinal = "Mesas de Convívio";
										                    c = new Localizacao(edificio,escolher_Piso,Localfinal, 0) ;
										                } else {
										                	System.out.println("*                                                                                    *");
										                    System.out.println("*                       Opção inválida/Invalid Option                                *");
										                    System.out.println("*                                                                                    *");
										                }

										                
										            }
										            
										            
										            break;

										        case 4: //piso 4
										        	System.out.println("*                                                                                    *");
										            System.out.println("*                          Piso 4 selecionado                                        *");
										            System.out.println("*                                                                                    *");
										            System.out.println("*  Escolher Salas 1 / Outros 2: ");
										            int escolher_tipo4 = ler.nextInt();

										            if (escolher_tipo4 == 1) {

										                System.out.print("Escolher Sala: ");
										                int escolher_sala = ler.nextInt();

										                metedos.verificarSala(escolher_Piso, escolher_sala);
										                c = new Localizacao(edificio, escolher_Piso, "Sala", escolher_sala);

										            } else if (escolher_tipo4 == 2) {
										            	System.out.println("*                                                                                    *");
										            	System.out.print("WC-1 , Corredor-2, Mesas de Convívio-3 : ");
										                int escolher_outros = ler.nextInt();

										                String Localfinal = "";

										                if (escolher_outros == 1) {
										                    Localfinal = "WC";
										                } else if (escolher_outros == 2) {
										                    Localfinal = "Corredor";
										                } else if (escolher_outros == 3) {
										                    Localfinal = "Mesas de Convívio";
										                } else {
										                	System.out.println("*                                                                                    *");
										                    System.out.println("*                     Opção inválida/Invalid Option                                  *");
										                    System.out.println("*                                                                                    *");
										                }
										                if (!Localfinal.isEmpty()) {
										                    c = new Localizacao(edificio, escolher_Piso, Localfinal, 0);
										                }

										            }
										            
										            
										            break;

										        case 5: //piso 5 
										        	System.out.println("*                                                                                    *");
										            System.out.println("*                           Piso 5 selecionado                                       *");
										            System.out.println("*                                                                                    *");
										            System.out.println("Escolher Salas 1 / Outros 2: ");
										            int escolher_tipo5 = ler.nextInt();

										            if (escolher_tipo5 == 1) {
										            	System.out.println("*                                                                                    *");
										                System.out.print("Escolher Sala: ");
										                int escolher_sala = ler.nextInt();

										                metedos.verificarSala(escolher_Piso, escolher_sala);
										                c = new Localizacao(edificio, escolher_Piso, "Sala", escolher_sala);

										            } else if (escolher_tipo5 == 2) {
										            	System.out.println("*                                                                                    *");
										            	System.out.print("WC-1 , Corredor-2, Mesas de Convívio-3 : ");
										                int escolher_outros = ler.nextInt();

										                String Localfinal = "";

										                if (escolher_outros == 1) {
										                    Localfinal = "WC";
										                } else if (escolher_outros == 2) {
										                    Localfinal = "Corredor";
										                } else if (escolher_outros == 3) {
										                    Localfinal = "Mesas de Convívio";
										                } else {
										                	System.out.println("*                                                                                    *");
										                    System.out.println("*                      Opção inválida/Invalid Option                                 *");
										                    System.out.println("*                                                                                    *");
										                }
										                if (!Localfinal.isEmpty()) {
										                    c = new Localizacao(edificio, escolher_Piso, Localfinal, 0);
										                }

										            }
										            
										            break;

										        case 6: //piso 6
										            System.out.println("Piso 6 selecionado");
										            System.out.println("Escolher Salas 1 / Outros 2: ");
										            int escolher_tipo6 = ler.nextInt();

										            if (escolher_tipo6 == 1) {

										                System.out.print("Escolher Sala: ");
										                int escolher_sala = ler.nextInt();

										                metedos.verificarSala(escolher_Piso, escolher_sala);
										                c = new Localizacao(edificio, escolher_Piso, "Sala", escolher_sala);

										            } else if (escolher_tipo6 == 2) {

										            	System.out.print("WC-1 , Corredor-2, Mesas de Convívio-3 : ");
										                int escolher_outros = ler.nextInt();

										                String Localfinal = "";

										                if (escolher_outros == 1) {
										                    Localfinal = "WC";
										                } else if (escolher_outros == 2) {
										                    Localfinal = "Corredor";
										                } else if (escolher_outros == 3) {
										                    Localfinal = "Mesas de Convívio";
										                } else {
										                    System.out.println("Opção inválida");
										                }
										                if (!Localfinal.isEmpty()) {
										                    c = new Localizacao(edificio, escolher_Piso, Localfinal, 0);
										                }

										            }
										            
										            break;

										        default:
										            System.out.println("Piso inválido");
										    }

										/// 2- edificio
										
										} else if (escolher_Edificio == 2) {
											System.out.println("*************************************************************************************");

										    System.out.print("Escolher o piso (1 a 3): ");
										    int escolher_Piso_Estacionamento = ler.nextInt();
										    String edificio = "Parque de Estacionamento";
										    
										    String LocalFinal = "Estacionamento"; 

										    switch (escolher_Piso_Estacionamento) {
										        case 1:
										            System.out.println("Piso 1 selecionado ");
										            c = new Localizacao(edificio, escolher_Piso_Estacionamento, LocalFinal, 0);										            
										            break;

										        case 2:
										            System.out.println("Piso 2 selecionado ");
										            c = new Localizacao(edificio, escolher_Piso_Estacionamento, LocalFinal, 0);
										            break;

										        case 3:
										            System.out.println("Piso 3 selecionado ");
										            c = new Localizacao(edificio, escolher_Piso_Estacionamento, LocalFinal, 0);
										            break;

										        default:
										            System.out.println("Piso inválido!");
										            break;
										    }
										
										    /// 3-edificio
										
										} else if (escolher_Edificio == 3) {
											System.out.println("*************************************************************************************");
										    System.out.print("Escolher o piso (1 a 2): ");
										    int escolher_Piso_SaoTome = ler.nextInt();
										    String edificio = "São Tomé";

										    switch (escolher_Piso_SaoTome) {

										        case 1: // piso 1

										            System.out.println("Piso 1 selecionado");
										            System.out.println("Cantina-1 Sala de Convivio-2 Wc-3 Corredor-4");

										            int escolher_outros = ler.nextInt();
										            String Localfinal = "";

										            if (escolher_outros == 1) {
										                Localfinal = "Cantina";
										                c = new Localizacao(edificio, escolher_Piso_SaoTome, Localfinal, 0);

										            } else if (escolher_outros == 2) {
										                Localfinal = "Sala de Convivio";
										                c = new Localizacao(edificio, escolher_Piso_SaoTome, Localfinal, 0);

										            } else if (escolher_outros == 3) {
										                Localfinal = "WC";
										                c = new Localizacao(edificio, escolher_Piso_SaoTome, Localfinal, 0);

										            } else if (escolher_outros == 4) {
										                Localfinal = "Corredor";
										                c = new Localizacao(edificio, escolher_Piso_SaoTome, Localfinal, 0);

										            } else {
										                System.out.println("Opção inválida");
										            }

										            break;

										        case 2: //piso 2 
										            System.out.println("Piso 2 selecionado");
										            System.out.println("Escolher Salas 1 / Outros 2: ");

										            int escolher_tipo2 = ler.nextInt();

										            if (escolher_tipo2 == 1) {

										                System.out.print("Escolher Sala: ");
										                int escolher_sala = ler.nextInt();

										                metedos.verificarSalaSaoTome(escolher_sala);

										                c = new Localizacao(edificio, escolher_Piso_SaoTome, "Sala", escolher_sala);

										            } else if (escolher_tipo2 == 2) {

										                System.out.print("WC-1, Corredor-2: ");
										                int escolher_outros2 = ler.nextInt();

										                String Localfinal2 = "";

										                if (escolher_outros2 == 1) {
										                    Localfinal2 = "WC";
										                    c = new Localizacao(edificio, escolher_Piso_SaoTome, Localfinal2, 0);

										                } else if (escolher_outros2 == 2) {
										                    Localfinal2 = "Corredor";
										                    c = new Localizacao(edificio, escolher_Piso_SaoTome, Localfinal2, 0);

										                } else {
										                    System.out.println("Opção inválida");
										                }
										            }
										            else {
										                  System.out.println("Opção inválida"); 
										             }

										            break;
										    }

										/// 4-edificio	
										    
										} else if (escolher_Edificio == 4) {
											System.out.println("*************************************************************************************");
										    System.out.println("Espelho D'agua selecionado");

										    String edificio = "Espelho D'agua";
										    String Localfinal = "Espelho D'agua";

										    c = new Localizacao(edificio, 0, Localfinal, 0);
										
										
										/// 5-edificio
										
										} else if (escolher_Edificio == 5) {

										    System.out.println("Jardim selecionado");

										    System.out.print("Escolher zona (1 a 3): ");
										    int escolher_Zona_Jardim = ler.nextInt();
										    String edificio = "Jardim";

										    switch (escolher_Zona_Jardim) {

										        case 1: //relva
										            System.out.println("Zona relvado selecionada");
										            c = new Localizacao(edificio, escolher_Zona_Jardim, "Relvado", 0);

										            break;

										        case 2: //bancos
										            System.out.println("Zona bancos selecionada");
										            c = new Localizacao(edificio, escolher_Zona_Jardim, "Bancos", 0);

										            break;

										        case 3: //entrada 
										            System.out.println("Zona entrada selecionada");
										            c = new Localizacao(edificio, escolher_Zona_Jardim, "Entrada", 0);

										            break;

										        default:
										            System.out.println("Opção inválida");
										            break;
										    }
										} else {

										    System.out.println("Edifício inválido");
										}
										
										System.out.println("*                                                                                    *");
										System.out.print("* Nivel Urgencia/Level of Urgency ((Menor/Less)1-5(Maior/Bigger)) : ");
										int nivel_ocorrencia = ler.nextInt();
										ler.nextLine();
										Ocorrencia oc = new Ocorrencia(nome_login, titulo_ocorrencia, descricao_ocorrencia, "Aberto", data_inicio, null, c, nivel_ocorrencia, categoria);
										metedos.registar_ocorrencia(oc);
										metedos.atribuir_trabalho(oc);
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*           Ocorrencia Criada com sucesso/Incident successfully created              *");
										System.out.println("*                                                                                    *");
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                 Categoria Invalida/Invalid Category                                *");
										System.out.println("*                                                                                    *");
									}
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                Tipo Utilizador Invalido/Invalid User Type                          *");
									System.out.println("*                                                                                    *");
								}
								
								break;
							
							//eleminar ocorrencia
							case 2:
								System.out.println("*                                                                                    *");
								System.out.print("* Título Ocorrencia/Title Occurrence : ");
								String titulo_ocorrencia = ler.nextLine();
								if(metedos.eliminar_ocorrencia(nome_login, titulo_ocorrencia)==1) {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                Eleminada com sucesso/Successfully eliminated                       *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*     Impossivel eleminar ocorrencia/It is impossible to eliminate the occurrence    *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
								}
								break;
								
							//denunciar equipa
							case 3:
								if (user.equals("Utilizador")) {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*      Registar denuncia a equipa / Register a complaint with the team               *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.print("* Nome da equipa/ Team name: ");
									String denunciar_equipa_nome = ler.nextLine();
									System.out.println("*                                                                                    *");
									System.out.print("* Nome da Categoria/ Category Name: ");
									String denunciar_equipa_categoria = ler.nextLine();
									System.out.println("*                                                                                    *");
									if (metedos.existe_equipa(denunciar_equipa_categoria, denunciar_equipa_nome) == 1) {
										System.out.print("* Descrição denuncia/ Description denounces: ");
										String denunciar_equipa_descricao = ler.nextLine();
										System.out.println("*                                                                                    *");
										LocalDate denuncia_equipa = LocalDate.now();
										Denuncia d_equipa = new Denuncia(nome_login, "EQUIPA", denunciar_equipa_nome, null, denunciar_equipa_descricao, denuncia_equipa);
										metedos.registar_denuncia(d_equipa);
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                  Equipa Denunciada/Team reported                                   *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*              Equipa invalida/Invalid team                                          *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									}
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                Tipo Utilizador Invalido/Invalid User Type                          *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
								}
								break;
							    
							//denunciar trabalho
							case 4:
								if (user.equals("Utilizador")) {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*               Registar denuncia trabalho / Register work report                    *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.print("* Nome da Ocorrencia/ Incident Name: ");
									String denunciar_trabalho_nome = ler.nextLine();
									System.out.println("*                                                                                    *");
									if (metedos.existe_titulo_utilizador(nome_login, denunciar_trabalho_nome) == 1) {
										System.out.print("* Descrição denuncia/ Description denounces: ");
										String denunciar_trabalho_descricao = ler.nextLine();
										System.out.println("*                                                                                    *");
										LocalDate denuncia_trabalho = LocalDate.now();
										Denuncia d_trabalho = new Denuncia(nome_login, "OCORRENCIA", null, denunciar_trabalho_nome, denunciar_trabalho_descricao, denuncia_trabalho);
										metedos.registar_denuncia(d_trabalho);
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                  Trabalho Denunciado/Job reported                                  *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*              Trabalho invalido/Invalid job                                         *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									}
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                Tipo Utilizador Invalido/Invalid User Type                          *");
									System.out.println("*                                                                                    *");
									System.out.println("**************************************************************************************");
								}
								break;
							// ver detalhes
							case 5:
								System.out.println("*                                                                                    *");
								System.out.print("* Título Ocorrencia : ");
								String titulo_ocorrencia1 = ler.nextLine();
								if (metedos.existe_titulo(titulo_ocorrencia1) == 1) {
									metedos.lista_ver_detalhes(nome_login, user, titulo_ocorrencia1, nome_equipa_entrar);
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*              Título invalido/Invalid Title                                         *");
									System.out.println("*                                                                                    *");
								}
								break;
							// lista ocorrencias
							case 6:
								if (user.equals("Admin")) {
								    metedos.lista_ocorrencia_admin();
								} else if (user.equals("Equipa")) {
								    metedos.lista_ocorrencia_equipa(nome_equipa_entrar);
								} else {
								    metedos.lista_ocorrencia_utilizador(nome_login);
								}
								break;
								
							// editar ocorrencia
							case 7:
								System.out.println("**************************************************************************************");
								System.out.println("*                                                                                    *");
								System.out.println("*           Título Ocorrencia/Title Occurrence                                       *");
								System.out.println("*                                                                                    *");
								System.out.println("**************************************************************************************");
								System.out.print("* Titulo: ");
								String titulo_editar = ler.nextLine();
								// Utilizador edita as suas próprias ocorrências
								if (metedos.existe_titulo_utilizador(nome_login, titulo_editar) == 1) {
									if (metedos.existe_ocorrencias(titulo_editar) == 1) {
										System.out.println("*                                                                                    *");
										System.out.println("*                            1-editar titulo/edit title                              *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            2-editar descrição/edit description                     *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            3-editar nivel de urgência/edit urgency level           *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            4-Voltar ao inicio/Back to top                          *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.print("* Opcao/Option: ");
										int escolha_menu_editar = ler.nextInt();
										System.out.println("* *");
										System.out.println("**************************************************************************************");
										ler.nextLine();
										switch (escolha_menu_editar) {
										case 1:
											System.out.println("*                                                                                    *");
											System.out.println("*                        Novo Titulo/New Title                                       *");
											System.out.println("*                                                                                    *");
											System.out.print("* Titulo: *");
											String nome_editar = ler.nextLine();
											metedos.editar_titulo_ocorrencia(nome_editar, nome_login, titulo_editar);
											break;
										case 2:
											System.out.println("*                                                                                    *");
											System.out.println("*                    Nova Descrição/New Description                                  *");
											System.out.println("*                                                                                    *");
											System.out.print("* Descrição: *");
											String descricao_editar = ler.nextLine();
											metedos.editar_descricao_ocorrencia(descricao_editar, nome_login, titulo_editar);
											break;
										case 3:
											System.out.println("*                                                                                    *");
											System.out.println("*               Novo Nível Urgencia/New Level of Urgency (1-5)                       *");
											System.out.println("*                                                                                    *");
											System.out.print("* Urgencia: *");
											int nivel_editar = ler.nextInt();
											ler.nextLine();
											if (nivel_editar >= 1 && nivel_editar <= 5) {
												metedos.editar_nivel_ocorrencia(nivel_editar, nome_login, titulo_editar);
											} else {
												System.out.println("**************************************************************************************");
												System.out.println("*                                                                                    *");
												System.out.println("*                         Nivel  Invalido/Invalid Level                              *");
												System.out.println("*                                                                                    *");
												System.out.println("**************************************************************************************");
											}
											break;
										case 4:
											break;
										default:
											System.out.println("**************************************************************************************");
											System.out.println("*                                                                                    *");
											System.out.println("*                     Opção Invalida/Invalid option                                  *");
											System.out.println("*                                                                                    *");
											System.out.println("**************************************************************************************");
											break;
										}
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                        Título Invalido/Invalid title                               *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									}
								// Admin/Equipa edita o estado de qualquer ocorrência
								} else {
									if (metedos.existe_ocorrencias(titulo_editar) == 1) {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("* 1-Editar Estado/Edit Status                             *");
										System.out.println("*                                                                                    *");
										System.out.println("* 2-Voltar ao Inicio/Back to Top                          *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.print("* Opcao: ");
										int escolha_menu_editar = ler.nextInt();
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
										ler.nextLine();
										if (escolha_menu_editar == 1) {
											if (metedos.ver_utilizador(user) == 1) {
												System.out.println("*                                                                                    *");
												System.out.println("*                   Novo Estado/New State (1-Em Processo / 2-Concluido )             *");
												System.out.println("*                                                                                    *");
												int estado_editar = ler.nextInt();
												ler.nextLine();
												String estado = metedos.transformar_estado(estado_editar);
												if (estado != null) {
													if (estado.equals("Em Processo")) {
														metedos.alterar_estado(titulo_editar, estado);
													} else {
														LocalDate data_estado = LocalDate.now();
														metedos.alterar_estado_data(titulo_editar, estado, data_estado);
													}
												} else {
													System.out.println("*                                                                                    *");
													System.out.println("*                        Estado Invalido/Invalid State                               *");
													System.out.println("*                                                                                    *");
												}
											} else {
												System.out.println("*                                                                                    *");
												System.out.println("*       O utilizador não tem permissões/The user does not have permissions.          *");
												System.out.println("*                                                                                    *");
											}
										} else if (escolha_menu_editar == 2) {
											// volta ao menu principal — não faz nada
										} else {
											System.out.println("**************************************************************************************");
											System.out.println("*                                                                                    *");
											System.out.println("*                     Opção Invalida/Invalid option                                  *");
											System.out.println("*                                                                                    *");
											System.out.println("**************************************************************************************");
										}
									} else {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                        Título Invalido/Invalid title                               *");
										System.out.println("*                                                                                    *");
										System.out.println("**************************************************************************************");
									}
								}
								break;
								
							// lista categorias
							case 8:
								metedos.lista_categorias();
								break;
								
							// criar categoria
							case 9:
								if (user.equals("Admin")) {
									System.out.println("*                                                                                    *");
									System.out.print("* Nome da Categoria : ");
									String nome_categoria = ler.nextLine();
									if (metedos.existe_categoria(nome_categoria) == 1) {
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*                     Categoria já existe/Category already exists                    *");
										System.out.println("*                                                                                    *");
									} else {
										Categoria nova = new Categoria(nome_categoria);
										metedos.registar_categoria(nova);
										System.out.println("**************************************************************************************");
										System.out.println("*                                                                                    *");
										System.out.println("*            Categoria criada com sucesso/Category created successfully.             *");
										System.out.println("*                                                                                    *");
									}
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*                Tipo Utilizador Invalido/Invalid User Type                          *");
									System.out.println("*                                                                                    *");
								}
								break;
								
							//criar equipa
							case 10:
								System.out.println("*                                                                                    *");
								System.out.print("* Categoria da equipa/Team category: ");
							    nome_categoria_entrar = ler.nextLine();

							    if (metedos.existe_categoria(nome_categoria_entrar) == 1) {
							    	System.out.println("*                                                                                    *");
							        System.out.print("* Nome da equipa/Team name: ");
							        nome_equipa_entrar = ler.nextLine();
							        System.out.println("*                                                                                    *");
							        System.out.print("* Lotacao/Capacity: ");
							        int lotacao = ler.nextInt();
							        ler.nextLine();

							        Equipa e= new Equipa(nome_equipa_entrar, nome_categoria_entrar, lotacao,0);
							        metedos.criar_equipa(e);

							        System.out.println("*                                                                                    *");
							        System.out.println("*                          Equipa adicionada com sucesso!                            *");
							        System.out.println("*                                                                                    *");

							    } else {

							        System.out.println("*                                                                                    *");
							        System.out.println("*                    Categoria nao existe / Category not found                      *");
							        System.out.println("*                                                                                    *");

							    }
							    break;
								
							//eleminar Membro
							case 11:
								System.out.println("**************************************************************************************");
							    System.out.println("*                                                                                    *");
							    System.out.println("*              Eliminar Membro de Equipa / Remove Team Member                        *");
							    System.out.println("*                                                                                    *");
							    System.out.println("**************************************************************************************");
							    System.out.println("*                                                                                    *");
							    System.out.print("* Nome da Equipa / Team Name: ");
							    String nomeEquipa_eliminar = ler.nextLine();
							    System.out.println("*                                                                                    *");
							    System.out.print("* Categoria da Equipa / Team Category: ");
							    String categoria_eliminar = ler.nextLine();
							    System.out.println("*                                                                                    *");
							    System.out.print("* Nome do Membro / Member Name: ");
							    String nomeMembro_eliminar = ler.nextLine();
							    System.out.println("*                                                                                    *");
							    System.out.print("* Motivo / Reason: ");
							    String porque_eliminar = ler.nextLine();

							    int resultado = metedos.eliminar_membro_criterio( nomeEquipa_eliminar, categoria_eliminar, nomeMembro_eliminar, porque_eliminar);
							    
							       

							    System.out.println("**************************************************************************************");
							    System.out.println("*                                                                                    *");
							    if (resultado == 1) {
							        System.out.println("*        Membro eliminado com sucesso / Member successfully removed                  *");
							    System.out.println("*                                                                                    *");
							    System.out.println("**************************************************************************************");
							    }
							    break;
								
							//eleminar equipa
							case 12:
								System.out.println("**************************************************************************************");
							    System.out.println("*                                                                                    *");
							    System.out.println("*                  Eliminar Equipa / Remove Team                                     *");
							    System.out.println("*                                                                                    *");
							    System.out.println("**************************************************************************************");
							    System.out.println("*                                                                                    *");
							    System.out.print("* Nome da Equipa / Team Name: ");
							    String nomeEquipa_eliminar_eq = ler.nextLine();
							    System.out.println("*                                                                                    *");
							    System.out.print("* Categoria da Equipa / Team Category: ");
							    String categoria_eliminar_eq = ler.nextLine();
							    System.out.println("*                                                                                    *");
							    System.out.print("* Motivo / Reason: ");
							    String porque_eliminar_eq = ler.nextLine();

							    int resultado_eq = metedos.eliminar_equipa(nomeEquipa_eliminar_eq, categoria_eliminar_eq, porque_eliminar_eq);
							    
							        

							    System.out.println("**************************************************************************************");
							    System.out.println("*                                                                                    *");
							    if (resultado_eq == 1) {
							        System.out.println("*           Equipa eliminada com sucesso / Team successfully removed                  *"); 
							    System.out.println("*                                                                                    *");
							    System.out.println("**************************************************************************************");
							    }
							    break;
								
							//lista denuncia
							case 13:
								System.out.println("*                                                                                    *");
								System.out.println("*      Total denuncias equipa / Total complaints team  : "+ metedos.total_denuncias_equipa()+"                         *");
								System.out.println("*                                                                                    *");
								System.out.println("*        Total denuncias trabalhos / Total complaints about jobs:"+metedos.total_denuncias_ocorrencias()+"                  *");
								metedos.listar_denuncias();
								break;
							//listar equipas  
							case 14:
								metedos.listar_equipas();
								break;
							
							//filtrar
							case 15:
								System.out.println("*                                                                                    *");
								System.out.println("*        1-Filtrar por mes / Filter by month                                         *");
								System.out.println("*                                                                                    *");
								System.out.println("*        2-Filtrar por ano / Filter by year                                          *");
								System.out.println("*                                                                                    *");
								System.out.println("**************************************************************************************");
								System.out.println("*                                                                                    *");
								System.out.print("* Opcao/Option: ");
								int opcao_filtrar = ler.nextInt();
								System.out.println("*                                                                                    *");
								System.out.println("**************************************************************************************");
								
								if(opcao_filtrar==1) {
									System.out.println("*                                                                                    *");
									System.out.print("* Mes/Month: ");
									int mes_filtrar = ler.nextInt();
									ler.nextLine();
									
									
									if(tipo_login==1) {
										metedos.filtrar_mes(mes_filtrar);
									}else {
										metedos.filtrar_mes_equipa_categoria(nome_equipa_entrar,nome_categoria_entrar, mes_filtrar);
									}
									
									
								} else if(opcao_filtrar == 2) {
									System.out.println("*                                                                                    *");
									System.out.print("* Ano/Year: ");
									int ano_filtrar = ler.nextInt();
									ler.nextLine();
									
									
									if(tipo_login==1) {
										metedos.filtrar_ano(ano_filtrar);
									}else {
										metedos.filtrar_ano_equipa_categoria(nome_equipa_entrar,nome_categoria_entrar, ano_filtrar);
									}
									
								} else {
									System.out.println("*                                                                                    *");
									System.out.println("*                            Opcao Invalido/Invalid Opcion                           *");
									System.out.println("*                                                                                    *");
								}
								break;
								
							
							}
						} while (escolha_menu_2 <16);
					} else {
						System.out.println("*                                                                                    *");
						System.out.println("*                            Tipo Invalido/Invalid Type                              *");
						System.out.println("*                                                                                    *");
					}
				} else {
					System.out.println("*                                                                                    *");
					System.out.println("*                          Nome Invalido/Invalid name                                *");
					System.out.println("*                                                                                    *");
				}
			// invalido
			} else if (escolha_menu_1 != 3) {
				System.out.println("*                                                                                    *");
				System.out.println("*                             Invalido/Invalid                                       *");
				System.out.println("*                                                                                    *");
			}
			
			if(escolha_menu_2==16) { //logout
				System.out.println("*                                                                                    *");
				System.out.println("*                          Logout efectuado com sucesso!                             *");
				System.out.println("*                                                                                    *");
			}
			
		} while (escolha_menu_1 != 3);
		// saída
		System.out.println("**************************************************************************************");
		System.out.println("*                                                                                    *");
		System.out.println("*                                 A sair/Leaving                                     *");
		System.out.println("*                                                                                    *");
		System.out.println("**************************************************************************************");
		ler.close(); // fechar o Scanner
	}
}