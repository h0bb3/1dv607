using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace CoolDiceGame
{
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window, DiceGameModel.DiceGameObserver
	{
		DiceGameModel.DiceGame m_game = new DiceGameModel.DiceGame();
		private int m_diceCounter;
		private System.ComponentModel.BackgroundWorker worker;

		public MainWindow()
		{
			m_game.AddSubscriber(this);
			InitializeComponent();

			worker = new System.ComponentModel.BackgroundWorker();
			worker.DoWork += new System.ComponentModel.DoWorkEventHandler(DoWork);
		}

		private void OnQuitClick(object sender, RoutedEventArgs e)
		{
			Close();
		}

		private void DoWork(object sender, System.ComponentModel.DoWorkEventArgs e)
		{

			m_diceCounter = 0;
			if (m_game.Play())
			{
				this.Dispatcher.BeginInvoke((Action)delegate()
				{
					GameStatus.Text = "You Won!!";
				});
			}
			else
			{

				this.Dispatcher.BeginInvoke((Action)delegate()
				{
					GameStatus.Text = "You Lost!!";
				});
			}
		}

		private void OnPlayClick(object sender, RoutedEventArgs e)
		{
			GameStatus.Text = "";
			Die1Status.Text = "Rolling...";
			Die2Status.Text = "";
			worker.RunWorkerAsync();
		}

		public void DiceRolled(int a_value)
		{
			this.Dispatcher.BeginInvoke((Action)delegate()
			{
				if (m_diceCounter == 0)
				{
					Die1Status.Text = a_value.ToString();
					Die2Status.Text = "Rolling...";
				}
				else
				{
					Die2Status.Text = a_value.ToString();

				}
				m_diceCounter++;

			});
		}
	}
}
