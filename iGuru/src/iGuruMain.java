import javax.swing.JFrame;
import javax.swing.JOptionPane;

class iGuruMain extends JFrame {
	
	public iGuruMain() {

		// loop to repeat initial dial entry
		boolean valid1 = false;
		while (!valid1) {
			try {
				String dial = JOptionPane.showInputDialog(
						"\nChoose between the five option:"
								+ "\nDial 1 - Multiplication Table"
								+ "\nDial 2 - Currency Convertion"
								+ "\nDial 3 - Temperature Units Convertion"
								+ "\nDial 4 - Length Units Convertion"
								+ "\nDial 5 - Weight Units Convertion"
								+ "\n‾‾‾‾‾‾‾‾‾[0:Back / X:Quit]‾‾‾‾‾‾‾‾‾",
						"[Option]");

				if (dial.equals("1")) {
					valid1 = true;

					// loop to repeat multiplication limit entry
					boolean valid2 = false;
					while (!valid2) {
						String limit = JOptionPane
								.showInputDialog(
										"\nEnter a number to usa a limit for operation?"
												+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾[Back: 0]‾",
										"[Limit]:");
						try {
							if (limit.equalsIgnoreCase("x")) {

								JOptionPane
										.showMessageDialog(
												null,
												"You have just quited the program.\nBYE!",
												"Quit",
												JOptionPane.PLAIN_MESSAGE);
								System.exit(0);
							} else {
								int nLimit = Integer.parseInt(limit);

								if (nLimit == 0) {
									valid2 = true;
									valid1 = false;

								} else {
									MultiplicationTable testMultiplicationTable = new MultiplicationTable(
											nLimit);
									testMultiplicationTable.result();
									valid1 = true;
									valid2 = false;
								}
							}
						} catch (Exception e) {
							valid2 = false;
						}
					}
					// Currency converter option
				} else if (dial.equals("2")) {
					valid1 = true;

					// loop to check if dial option is in range
					boolean valid3 = false;
					while (!valid3) {
						String type = JOptionPane
								.showInputDialog(
										"Dial 1 - Convert from Gambian Dalasi"
												+ "\nDial 2 - Convert from United States Dollar"
												+ "\nDial 3 - Convert from West African CFA Franc"
												+ "\nDial 4 - Convert from Europian Euro"
												+ "\nDial 5 - Convert from British Pounds Starling"
												+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾[Back: 0]‾",
										"[Limit]:");
						try {
							// back if entry is 0
							if (type.equals("0")) {
								valid1 = false;
								valid3 = true;
							}
							// quit if entry is -1
							else if (type.equalsIgnoreCase("x")) {
								JOptionPane
										.showMessageDialog(
												null,
												"You have just quited the program.\nBYE!",
												"Quit",
												JOptionPane.PLAIN_MESSAGE);
								System.exit(0);
							}

							// if option is chosen between the 5 options
							else if (type.equals("1") || type.equals("2")
									|| type.equals("3") || type.equals("4")
									|| type.equals("5")) {
								valid3 = true;

								// to check if entered amount is valid
								boolean valid4 = false;
								while (!valid4) {
									String amount = null;
									if (type.equals("1")) {
										amount = JOptionPane
												.showInputDialog(
														"\nEnter Gambian Dalasi amount:",
														"[Amount]:");
									} else if (type.equals("2")) {
										amount = JOptionPane
												.showInputDialog(
														"\nEnter United States Dollar amount:",
														"[Amount]:");
									} else if (type.equals("3")) {
										amount = JOptionPane
												.showInputDialog(
														"\nEnter West African CFA Franc amount:",
														"[Amount]:");
									} else if (type.equals("4")) {
										amount = JOptionPane
												.showInputDialog(
														"\nEnter Europian Euro amount:",
														"[Amount]:");
									} else if (type.equals("5")) {
										amount = JOptionPane
												.showInputDialog(
														"\nEnter British Pounds Starling amount:",
														"[Amount]:");
									}
									try {
										if (amount.equalsIgnoreCase("x")) {
											JOptionPane
													.showMessageDialog(
															null,
															"You have just quited the program.\nBYE!",
															"Quit",
															JOptionPane.PLAIN_MESSAGE);
											System.exit(0);
										} else {

											Double Amount = Double
													.parseDouble(amount);
											if (Amount == 0) {
												valid3 = false;
												valid4 = true;

											} else {
												CurrencyUnit testCurrencyUnit = new CurrencyUnit(
														Amount, type);
												testCurrencyUnit.result();
												valid3 = false;
											}
										}
									} catch (Exception e) {
										valid4 = false;
									}
								}
							}
						} catch (Exception e) {
							valid3 = false;
						}
					}
					// Temperature converter option
				} else if (dial.equals("3")) {
					valid1 = true;

					// loop to check if dial option is in range
					boolean valid5 = false;
					while (!valid5) {
						String type = JOptionPane
								.showInputDialog(
										"\nDial 1 - Convert from Celsius"
												+ "\nDial 2 - Convert from Fahrenheit"
												+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾[Back: 0]‾",
										"[Option]:");
						try {
							if (type.equals("0")) {
								valid1 = false;
								valid5 = true;
							}
							// quit if entry is -1
							else if (type.equals("-1")) {
								JOptionPane
										.showMessageDialog(
												null,
												"You have just quited the program.\nBYE!",
												"Quit",
												JOptionPane.PLAIN_MESSAGE);
								System.exit(0);
							}
							// if option chosen is between 2 option
							else if (type.equals("1") || type.equals("2")) {
								valid5 = true;

								// to check if temperature if entered amount is
								// valid
								boolean valid6 = false;
								while (!valid6) {
									String amount = null;
									if (type.equals("1")) {

										amount = JOptionPane
												.showInputDialog(
														"Enter Celsius temperature value:",
														"[Value]:");

									} else if (type.equals("2")) {
										amount = JOptionPane
												.showInputDialog(
														"Enter Farenhites temperature value:",
														"[Value]:");
									}
									try {
										double Amount = Double
												.parseDouble(amount);
										if (Amount == 0) {
											valid5 = false;
											valid6 = true;
										}
										// quit if entry is -1
										else if (Amount == -1) {
											JOptionPane
													.showMessageDialog(
															null,
															"You have just quited the program.\nBYE!",
															"Quit",
															JOptionPane.PLAIN_MESSAGE);
											System.exit(0);
										} else {
											TemperatureUnit testTemperatureUnit = new TemperatureUnit(
													type, Amount);
											testTemperatureUnit.result();
											valid5 = false;
										}
									} catch (Exception e) {
										valid6 = false;
									}
								}
							}

						} catch (Exception e) {
							valid5 = false;

						}
					}
					// length unit option
				} else if (dial.equals("4")) {
					valid1 = true;

					// loop to check if dial option is in range
					boolean valid7 = false;
					while (!valid7) {

						String type = JOptionPane
								.showInputDialog(
										"\nDial 1 - For km - mile Converter"
												+ "\nDial 2 - For  m - yard Converter"
												+ "\nDial 3 - For  m - foot Converter"
												+ "\nDial 4 - For cm - inch Converter"
												+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾[Back: 0]‾",
										"[Option]:");
						try {
							if (type.equals("0")) {
								valid1 = false;
								valid7 = true;
							}
							// quit if entry is -1
							else if (type.equals("-1")) {
								JOptionPane
										.showMessageDialog(
												null,
												"You have just quited the program.\nBYE!",
												"Quit",
												JOptionPane.PLAIN_MESSAGE);
								System.exit(0);
							}

							// if option is chosen between the 4 options
							else if (type.equals("1") || type.equals("2")
									|| type.equals("3") || type.equals("4")) {
								valid7 = true;
								String amount1 = null;
								String say1 = null;
								String say2 = null;
								if (type.equals("1")) {
									say1 = "Enter amount in (km) unit:";
									say2 = "Enter amount in (mile) unit:";
								} else if (type.equals("2")) {
									say1 = "Enter amount in (m) unit:";
									say2 = "Enter amount in (yard) unit:";
								} else if (type.equals("3")) {
									say1 = "Enter amount in (m) unit:";
									say2 = "Enter amount in (foot) unit:";
								} else if (type.equals("4")) {
									say1 = "Enter amount in (cm) unit:";
									say2 = "Enter amount in (inch) unit:";
								}

								// to check if entered amount is valid
								boolean valid8 = false;
								while (!valid8) {
									amount1 = JOptionPane.showInputDialog(say1,
											"[Amount]:");
									try {
										Double Amount1 = Double
												.parseDouble(amount1);
										Double Amount = Double
												.parseDouble(amount1);
										if (Amount1 == 0) {
											boolean valid9 = false;
											while (!valid9) {
												amount1 = JOptionPane
														.showInputDialog(say2,
																"[Amount]:");

												try {
													Double Amount2 = Double
															.parseDouble(amount1);

													if (Amount2 == 0) {
														valid8 = true;
														valid9 = true;
														valid7 = false;
													}
													// quit if entry is -1
													else if (Amount2 == -1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"You have just quited the program.\nBYE!",
																		"Quit",
																		JOptionPane.PLAIN_MESSAGE);
														System.exit(0);
													} else {
														valid9 = true;
														LengthUnit testLengthUnit = new LengthUnit(
																type, Amount1,
																Amount2);
														testLengthUnit.result();
														valid7 = false;
													}

												} catch (Exception e) {
													valid9 = false;
												}
											}
										}
										// quit if entry is -1
										else if (Amount1 == -1) {
											JOptionPane
													.showMessageDialog(
															null,
															"You have just quited the program.\nBYE!",
															"Quit",
															JOptionPane.PLAIN_MESSAGE);
											System.exit(0);
										} else {
											LengthUnit testLengthUnit = new LengthUnit(
													type, Amount1, Amount);
											testLengthUnit.result();
											valid7 = false;
										}
									} catch (Exception e) {
										valid8 = false;
									}
								}
							} else {
								valid7 = false;
							}
						} catch (Exception e) {
							valid7 = false;
						}
					}

				} else if (dial.equals("5")) {
					valid1 = true;

					// loop to check if dial option is in range
					boolean valid10 = false;
					while (!valid10) {
						String type = JOptionPane
								.showInputDialog(
										"\nDial 1 - For kg - pound Converter"
												+ "\nDial 2 - For kg - ton Converter"
												+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾[Back: 0]‾",
										"[Option]:");
						try {

							if (type.equals("0")) {
								valid1 = false;
								valid10 = true;
							}
							// quit if entry is -1
							else if (type.equals("-1")) {
								JOptionPane
										.showMessageDialog(
												null,
												"You have just quited the program.\nBYE!",
												"Quit",
												JOptionPane.PLAIN_MESSAGE);
								System.exit(0);
							}
							// if option is chosen between the 2 options
							else if (type.equals("1") || type.equals("2")) {
								valid10 = true;

								String amount1 = null;
								String say1 = null;
								String say2 = null;
								if (type.equals("1")) {
									say1 = "Enter amount in (kg) unit:";
									say2 = "Enter amount in (pound) unit:";
								} else if (type.equals("2")) {
									say1 = "Enter amount in (kg) unit:";
									say2 = "Enter amount in (ton) unit:";
								}
								// to check if entered amount is valid
								boolean valid11 = false;
								while (!valid11) {
									amount1 = JOptionPane.showInputDialog(say1,
											"[Amount]:");
									try {
										Double Amount1 = Double
												.parseDouble(amount1);
										Double Amount = Double
												.parseDouble(amount1);
										if (Amount1 == 0) {
											boolean valid12 = false;
											while (!valid12) {
												amount1 = JOptionPane
														.showInputDialog(say2,
																"[Amount]:");

												try {
													Double Amount2 = Double
															.parseDouble(amount1);

													if (Amount2 == 0) {
														valid11 = true;
														valid12 = true;
														valid10 = false;
													}
													// quit if entry is -1
													else if (Amount1 == -1) {
														JOptionPane
																.showMessageDialog(
																		null,
																		"You have just quited the program.\nBYE!",
																		"Quit",
																		JOptionPane.PLAIN_MESSAGE);
														System.exit(0);
													} else {
														valid12 = true;
														WeightUnit testWeightUnit = new WeightUnit(
																type, Amount1,
																Amount2);
														testWeightUnit.result();
														valid10 = false;
													}

												} catch (Exception e) {
													valid12 = false;
												}
											}
										}
										// quit if entry is -1
										else if (Amount1 == -1) {
											JOptionPane
													.showMessageDialog(
															null,
															"You have just quited the program.\nBYE!",
															"Quit",
															JOptionPane.PLAIN_MESSAGE);
											System.exit(0);
										} else {
											WeightUnit testWeightUnit = new WeightUnit(
													type, Amount1, Amount);
											testWeightUnit.result();
											valid10 = false;
										}
									} catch (Exception e) {
										valid11 = false;
									}
								}
							} else {
								valid10 = false;
							}
						} catch (Exception e) {
							valid10 = false;

						}
					}

				}
				// quit if entry is -1
				else if (dial.equals("0") || dial.equalsIgnoreCase("x")) {
					JOptionPane.showMessageDialog(null,
							"You have just quited the program.\nBYE!", "Quit",
							JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}

			} catch (Exception e) {
				valid1 = false;
			}
		}
	}
}