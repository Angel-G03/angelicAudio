import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI implements ActionListener {
	
	protected static JFrame frame = new JFrame();
	protected static JPanel panel = new JPanel();
	protected static JButton playButton;
	protected static JButton pauseButton;
	protected static JButton resetButton;
	protected static JButton lastButton;
	protected static JButton nextButton;
	protected static JButton quitButton;
	protected static File deathFile;
	protected static AudioInputStream audioStream;
	protected static Clip clip;
	protected static JLabel label;
	protected static ImageIcon deathCover;
	protected static int count = 0;
	

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
		//Window Initialization
		frame.setSize(615,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		frame.setTitle("Angelic Audio");
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		frame.setResizable(false);
		
		//Title Label
		JLabel titleLabel = new JLabel();
		ImageIcon titleImage = new ImageIcon("images/Angelic Audio.png");
		titleLabel.setIcon(titleImage);
		titleLabel.setBounds(150,20,600,150);
		panel.add(titleLabel);
		
		//Album Label 1
		label = new JLabel();
		label.setBounds(50,150,500,525);
		label.setText("Spiritual Healing - Death - Song 1");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		panel.add(label);
		
		//Album cover 1
		deathCover = new ImageIcon("images/DeathAlbumCover 2.png");
		label.setIcon(deathCover);
		
		//Song 1
		deathFile = new File("music/SpiritualHealing.wav");
		audioStream = AudioSystem.getAudioInputStream(deathFile);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		//Play button
		playButton = new JButton("Start");
		playButton.addActionListener(new GUI());
		playButton.setBounds(20,750,80,25);
		panel.add(playButton);
		
		//Pause button
		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(new GUI());
		pauseButton.setBounds(120,750,80,25);
		panel.add(pauseButton);
		
		//Restart button
		resetButton = new JButton("Restart");
		resetButton.addActionListener(new GUI());
		resetButton.setBounds(220,750,80,25);
		panel.add(resetButton);
		
		//Last button
		lastButton = new JButton("Last");
		lastButton.addActionListener(new GUI());
		lastButton.setBounds(320,750,80,25);
		panel.add(lastButton);
		
		//Next button
		nextButton = new JButton("Next");
		nextButton.addActionListener(new GUI());
		nextButton.setBounds(420,750,80,25);
		panel.add(nextButton);
		
		//Quit button
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new GUI());
		quitButton.setBounds(520,750,80,25);
		panel.add(quitButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		//User clicks play
		if (event == playButton) {
			clip.start();
		}
		//User clicks pause
		else if (event == pauseButton) {
			clip.stop();
		}
		//User restarts song
        else if (event == resetButton) {
			clip.setMicrosecondPosition(0);
		}
		//User picks next song
        else if (event == nextButton) {
        	clip.close();
        	switch(count) {
				//Song 1
        	    case 0: label.setText("Spiritual Healing - Death - Song 1");
        	    ImageIcon cover = new ImageIcon("images/DeathAlbumCover 2.png");
        	    label.setIcon(cover);
        	    File dethFile = new File("music/SpiritualHealing.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(dethFile);
				} catch (UnsupportedAudioFileException | IOException e2) {					
					e2.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e2) {			
					e2.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException e2) {				
					e2.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
        	    break;
        	
				//Song 2
        	    case 1: label.setText("Stayin' Alive - Bee Gees - Song 2");
        	    ImageIcon funkCover = new ImageIcon("images/cover2.png");
        	    label.setIcon(funkCover);
        	    File funkFile = new File("music/Stayin' Alive.wav");
        	    //No idea what this is but it doesn't work without it
        	    try {
					audioStream = AudioSystem.getAudioInputStream(funkFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 3
        	    case 2: label.setText("Spring - Vivaldi - Song 3");
        	    ImageIcon classCover = new ImageIcon("images/vivaldi.png");
        	    label.setIcon(classCover);
        	    File classFile = new File("music/vivaldi.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(classFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 4
        	    case 3: label.setText("Dirty Deeds - AC/DC - Song 4");
        	    ImageIcon rockCover = new ImageIcon("images/acdc.png");
        	    label.setIcon(rockCover);
        	    File rockFile = new File("music/acdc.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(rockFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 5
        	    case 4: label.setText("Smart Patrol - Devo - Song 5");
        	    ImageIcon techCover = new ImageIcon("images/devo.png");
        	    label.setIcon(techCover);
        	    File techFile = new File("music/devo.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(techFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 6
        	    case 5: label.setText("Just Lose It - Eminem - Song 6");
        	    ImageIcon rapCover = new ImageIcon("images/em.png");
        	    label.setIcon(rapCover);
        	    File rapFile = new File("music/em.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(rapFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
        	    break;
        	}

			//Reached last song, goes to first song
        	if (count == 5) {
        		count = -1;
        	}
        	count++;
		}

		//User picks last song
        else if (event == lastButton) {
            count--;
            clip.close();
        	switch(count) {
				//Song 1
        	    case 0: label.setText("Spiritual Healing - Death - Song 1");
        	    ImageIcon cover = new ImageIcon("images/DeathAlbumCover 2.png");
        	    label.setIcon(cover);
        	    File dethFile = new File("music/SpiritualHealing.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(dethFile);
				} catch (UnsupportedAudioFileException | IOException e2) {
					e2.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e2) {
					e2.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException e2) {
					e2.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
        	    break;
        	
				//Song 2
        	    case 1: label.setText("Stayin' Alive - Bee Gees - Song 2");
        	    ImageIcon funkCover = new ImageIcon("images/cover2.png");
        	    label.setIcon(funkCover);
        	    File funkFile = new File("music/Stayin' Alive.wav");
        	    //No idea what this is but it doesn't work without it
        	    try {
					audioStream = AudioSystem.getAudioInputStream(funkFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 3
        	    case 2: label.setText("Spring - Vivaldi - Song 3");
        	    ImageIcon classCover = new ImageIcon("images/vivaldi.png");
        	    label.setIcon(classCover);
        	    File classFile = new File("music/vivaldi.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(classFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 4
        	    case 3: label.setText("Dirty Deeds - AC/DC - Song 4");
        	    ImageIcon rockCover = new ImageIcon("images/acdc.png");
        	    label.setIcon(rockCover);
        	    File rockFile = new File("music/acdc.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(rockFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 5
        	    case 4: label.setText("Smart Patrol - Devo - Song 5");
        	    ImageIcon techCover = new ImageIcon("images/devo.png");
        	    label.setIcon(techCover);
        	    File techFile = new File("music/devo.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(techFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException | IOException e1) {
					e1.printStackTrace();
				}
        	    break;
        	    
				//Song 6
        	    case 5: label.setText("Just Lose It - Eminem - Song 6");
        	    ImageIcon rapCover = new ImageIcon("images/em.png");
        	    label.setIcon(rapCover);
        	    File rapFile = new File("music/em.wav");
        	    try {
					audioStream = AudioSystem.getAudioInputStream(rapFile);
				} catch (UnsupportedAudioFileException | IOException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
        	    try {
					clip.open(audioStream);
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	    break;         	
            }

			//Reached first song, goes to last song
        	if (count<0) {
        		count = 7;
        	}
        }
		
		//User clicks quit
        else {
        	clip.close();
        	System.exit(0);
        }
	}
}