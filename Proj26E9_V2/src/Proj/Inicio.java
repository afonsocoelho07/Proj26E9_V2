package Proj;
import java.util.Scanner;
import java.time.LocalDate;
public class Inicio {
	public static void main(String[] args) {
		Gerir_ocorrencia metedos = new Gerir_ocorrencia();
		Scanner ler = new Scanner(System.in);
		int escolha_menu_1;
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
					System.out.println("* *");
					ler.nextLine();
					String user = metedos.existe_tipo_utilizador(tipo_login);
					if (user != null) {
						int escolha_menu_2;
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
							}

							System.out.println("*                                                                                    *");
							System.out.println("*        2-Ver detalhes/View Details                                                 *");
							System.out.println("*        3-Lista Ocorrencias/List of Occurrences                                     *");
							System.out.println("*        4-Editar Ocorrencia/Edit Occurrence                                         *");
							System.out.println("*        5-Lista Categorias/List categories                                          *");
							if (user.equals("Equipa") || user.equals("Admin")) {

								System.out.println("*                                                                                    *");
								System.out.println("*        6-Criar Categoria/Create Category                                           *");
								System.out.println("*        7-Filtrar mes/ano /Filter by month/year                                     *");
							}
							System.out.println("*        8-Logout                                                                    *");
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
										System.out.print("* Localização Ocorrencia/Occurrence Location : ");
										String localizacao_ocorrencia = ler.nextLine();
										System.out.println("*                                                                                    *");
										System.out.print("* Nivel Urgencia/Level of Urgency ((Menor/Less)1-5(Maior/Bigger)) : ");
										int nivel_ocorrencia = ler.nextInt();
										ler.nextLine();
										Ocorrencia oc = new Ocorrencia(nome_login, titulo_ocorrencia, descricao_ocorrencia, "Aberto", data_inicio, null, localizacao_ocorrencia, nivel_ocorrencia, categoria);
										metedos.registar_ocorrencia(oc);
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
							// ver detalhes
							case 2:
								System.out.println("*                                                                                    *");
								System.out.print("* Título Ocorrencia : ");
								String titulo_ocorrencia = ler.nextLine();
								if (metedos.existe_titulo(titulo_ocorrencia) == 1) {
									metedos.lista_ver_detalhes(nome_login, user, titulo_ocorrencia);
								} else {
									System.out.println("**************************************************************************************");
									System.out.println("*                                                                                    *");
									System.out.println("*              Título invalido/Invalid Title                                         *");
									System.out.println("*                                                                                    *");
								}
								break;
							// lista ocorrencias
							case 3:
								if (user.equals("Admin") || user.equals("Equipa")) {
									metedos.lista_ocorrencia_admin();
								} else {
									metedos.lista_ocorrencia_utilizador(nome_login);
								}
								break;
							// editar ocorrencia
							case 4:
								System.out.println("**************************************************************************************");
								System.out.println("*                                                                                    *");
								System.out.println("*           Título Ocorrencia/Title Occurrence                                       *");
								System.out.println("*                                                                                    *");
								System.out.println("**************************************************************************************");
								String titulo_editar = ler.nextLine();
								// Utilizador edita as suas próprias ocorrências
								if (metedos.existe_titulo_utilizador(nome_login, titulo_editar) == 1) {
									if (metedos.existe_ocorrencias(titulo_editar) == 1) {
										System.out.println("*                                                                                    *");
										System.out.println("*                            1-editar titulo/edit title                              *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            2-editar descrição/edit description                     *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            3-editar localização/edit location                      *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            4-editar nivel de urgência/edit urgency level           *");
										System.out.println("*                                                                                    *");
										System.out.println("*                            5-Voltar ao inicio/Back to top                          *");
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
											System.out.println("* Nova Localização/New Location                              *");
											System.out.println("*                                                                                    *");
											System.out.print("* Localização: *");
											String localizacao_editar = ler.nextLine();
											metedos.editar_localizacao_ocorrencia(localizacao_editar, nome_login, titulo_editar);
											break;
										case 4:
											System.out.println("* *");
											System.out.println("* Novo Nível Urgencia/New Level of Urgency (1-5)                *");
											System.out.println("* *");
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
										case 5:
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
							case 5:
								metedos.lista_categorias();
								break;
							// criar categoria
							case 6:
								if (user.equals("Equipa") || user.equals("Admin")) {
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
							//filtrar
							case 7:
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
									metedos.filtrar_mes(mes_filtrar);
								} else if(opcao_filtrar == 2) {
									System.out.println("*                                                                                    *");
									System.out.print("* Ano/Year: ");
									int ano_filtrar = ler.nextInt();
									ler.nextLine();
									metedos.filtrar_ano(ano_filtrar);
								} else {
									System.out.println("*                                                                                    *");
									System.out.println("*                            Opcao Invalido/Invalid Opcion                           *");
									System.out.println("*                                                                                    *");
								}
								break;
								
							// logout
							case 8:
								System.out.println("*                                                                                    *");
								System.out.println("*                          Logout efectuado com sucesso!                             *");
								System.out.println("*                                                                                    *");
								break;
							default:
								System.out.println("**************************************************************************************");
								System.out.println("*                                                                                    *");
								System.out.println("*                          Opção Invalida/Invalid option                             *");
								System.out.println("*                                                                                    *");
								System.out.println("**************************************************************************************");
								break;
							}
						} while (escolha_menu_2 != 8);
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
		} while (escolha_menu_1 != 3);
		// saída
		System.out.println("**************************************************************************************");
		System.out.println("*                                                                                    *");
		System.out.println("*                                 A sair/Leaving                                     *");
		System.out.println("*                                                                                    *");
		System.out.println("**************************************************************************************");
		ler.close(); // fechar scanner
	}
}
