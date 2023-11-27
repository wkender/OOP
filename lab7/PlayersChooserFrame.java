package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.*;

public class PlayersChooserFrame extends JFrame {
	private JButton saveButton, resetButton, takeButton, returnButton, takeAllButton, returnAllButton;
	private DefaultListModel<String> playersModel, teamModel;
	private JList<String> playersList, teamList;
	public PlayersChooserFrame() {
		super("Players List");
		setSize(500,500);
		setLayout(new BorderLayout());
		createMenuBar();
		createToolbar();
		createListPanel();
		createButtonsListener();
		createToolBarListeners();
	}
	
	private void createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu filemenu = new JMenu("File");
		menubar.add(filemenu);
		JMenuItem exitFile = new JMenuItem("Exit");
		exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		exitFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(getParent(), "Are you sure you want to quit?", "Confirm quit",
						JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null);
				if (option == JOptionPane.OK_OPTION) System.exit(0);
			}
			
		});
		filemenu.add(exitFile);
	}
	
	private void createToolbar() {
		saveButton = new JButton("Save");
		resetButton = new JButton("Reset");
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout());
		toolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toolbar.add(saveButton);
		toolbar.add(resetButton);
		add(toolbar, BorderLayout.NORTH);
	}
	
	private void createListPanel() {
		playersModel = new DefaultListModel<String>();
		for (String player : PlayersBase.getPlayers()) {
			playersModel.addElement(player);
		}
		teamModel = new DefaultListModel<String>();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		playersList = new JList<String>(playersModel);
		playersList.setToolTipText("Доступные игроки");
		playersList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		teamList = new JList<String>(teamModel);
		teamList.setToolTipText("Игроки в команде");
		teamList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(playersList);
		panel.add(createButtonsPanel());
		panel.add(teamList);
		add(panel,BorderLayout.CENTER);
	}
	
	private JPanel createButtonsPanel() {
		JPanel buttonspanel = new JPanel();
		buttonspanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonspanel.setLayout(new GridLayout(4,0));
		takeButton = new JButton(">");
		takeButton.setToolTipText("Добавить выбранного игрока");
		takeAllButton = new JButton(">>");
		takeAllButton.setToolTipText("Добавить всех игроков");
		returnButton = new JButton("<");
		returnButton.setToolTipText("Вернуть выбранного игрока");
		returnAllButton = new JButton("<<");
		returnAllButton.setToolTipText("Вернуть всех игроков");
		buttonspanel.add(takeButton);
		buttonspanel.add(takeAllButton);
		buttonspanel.add(returnButton);
		buttonspanel.add(returnAllButton);
		return buttonspanel;
	}
	
	private void createButtonsListener() {
		takeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> selection = playersList.getSelectedValuesList();
				for (String player : selection) {
					teamModel.addElement(player);
					playersModel.removeElement(player);
				}
				
				
			}
			
		});
		takeAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<String> elements = playersModel.elements();
				while (elements.hasMoreElements()) {
					String next = elements.nextElement();
					teamModel.addElement(next);
				}
				playersModel.removeAllElements();
				
			}
			
		});
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<String> selection = teamList.getSelectedValuesList();
				for (String teams : selection) {
					playersModel.addElement(teams);
					teamModel.removeElement(teams);
				}
				
				
			}
			
		});
		
		returnAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<String> elements = teamModel.elements();
				while (elements.hasMoreElements()) {
					String next = elements.nextElement();
					playersModel.addElement(next);
				}
				teamModel.removeAllElements();
				
			}
			
		});
	}
	
	private void createToolBarListeners() {
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String all = "";
				Enumeration<String> elements = teamModel.elements();
				while(elements.hasMoreElements()) {
					all += elements.nextElement() +"\n";
					JOptionPane.showMessageDialog(getParent(), all, "Выбраны следующие игроки:", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teamModel.removeAllElements();
				playersModel.removeAllElements();
				for (String player : PlayersBase.getPlayers()) {
					playersModel.addElement(player);
				}
				
			}
			
		});
	}
}
