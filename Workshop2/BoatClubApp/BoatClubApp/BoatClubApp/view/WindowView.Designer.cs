namespace BoatClubApp
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.button2 = new System.Windows.Forms.Button();
            this.buttonSave = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textBoxPersonalNo = new System.Windows.Forms.TextBox();
            this.textBoxName = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radioButtonVerbose = new System.Windows.Forms.RadioButton();
            this.radioButtonCompact = new System.Windows.Forms.RadioButton();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.ButtonView = new System.Windows.Forms.Button();
            this.buttonAddBoat = new System.Windows.Forms.Button();
            this.buttonDelete = new System.Windows.Forms.Button();
            this.listBoxMemberList = new System.Windows.Forms.ListBox();
            this.tabPage1.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.tabControl1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabPage1
            // 
            this.tabPage1.BackColor = System.Drawing.Color.WhiteSmoke;
            this.tabPage1.Controls.Add(this.buttonDelete);
            this.tabPage1.Controls.Add(this.buttonAddBoat);
            this.tabPage1.Controls.Add(this.ButtonView);
            this.tabPage1.Controls.Add(this.button2);
            this.tabPage1.Controls.Add(this.buttonSave);
            this.tabPage1.Controls.Add(this.label5);
            this.tabPage1.Controls.Add(this.label4);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.textBoxPersonalNo);
            this.tabPage1.Controls.Add(this.textBoxName);
            this.tabPage1.Controls.Add(this.groupBox1);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Controls.Add(this.listBoxMemberList);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(755, 466);
            this.tabPage1.TabIndex = 1;
            this.tabPage1.Text = "Tab 1";
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(597, 435);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(150, 23);
            this.button2.TabIndex = 10;
            this.button2.Text = "Quit Application";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // buttonSave
            // 
            this.buttonSave.Location = new System.Drawing.Point(211, 170);
            this.buttonSave.Name = "buttonSave";
            this.buttonSave.Size = new System.Drawing.Size(75, 23);
            this.buttonSave.TabIndex = 9;
            this.buttonSave.Text = "Save";
            this.buttonSave.UseVisualStyleBackColor = true;
            this.buttonSave.Click += new System.EventHandler(this.buttonSave_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(25, 79);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(166, 20);
            this.label5.TabIndex = 8;
            this.label5.Text = "Register New Member";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(26, 154);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(68, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "Personal No.";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(26, 105);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(35, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Name";
            // 
            // textBoxPersonalNo
            // 
            this.textBoxPersonalNo.Location = new System.Drawing.Point(29, 170);
            this.textBoxPersonalNo.Name = "textBoxPersonalNo";
            this.textBoxPersonalNo.Size = new System.Drawing.Size(162, 20);
            this.textBoxPersonalNo.TabIndex = 5;
            // 
            // textBoxName
            // 
            this.textBoxName.Location = new System.Drawing.Point(29, 121);
            this.textBoxName.Name = "textBoxName";
            this.textBoxName.Size = new System.Drawing.Size(162, 20);
            this.textBoxName.TabIndex = 4;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioButtonVerbose);
            this.groupBox1.Controls.Add(this.radioButtonCompact);
            this.groupBox1.Location = new System.Drawing.Point(29, 215);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(275, 45);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "List Members";
            // 
            // radioButtonVerbose
            // 
            this.radioButtonVerbose.AutoSize = true;
            this.radioButtonVerbose.Location = new System.Drawing.Point(150, 20);
            this.radioButtonVerbose.Name = "radioButtonVerbose";
            this.radioButtonVerbose.Size = new System.Drawing.Size(64, 17);
            this.radioButtonVerbose.TabIndex = 1;
            this.radioButtonVerbose.TabStop = true;
            this.radioButtonVerbose.Text = "Verbose";
            this.radioButtonVerbose.UseVisualStyleBackColor = true;
            // 
            // radioButtonCompact
            // 
            this.radioButtonCompact.AutoSize = true;
            this.radioButtonCompact.Location = new System.Drawing.Point(21, 20);
            this.radioButtonCompact.Name = "radioButtonCompact";
            this.radioButtonCompact.Size = new System.Drawing.Size(67, 17);
            this.radioButtonCompact.TabIndex = 0;
            this.radioButtonCompact.TabStop = true;
            this.radioButtonCompact.Text = "Compact";
            this.radioButtonCompact.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Franklin Gothic Book", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(292, 41);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(148, 17);
            this.label2.TabIndex = 2;
            this.label2.Text = "Member Registration App";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Papyrus", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(264, 2);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(215, 46);
            this.label1.TabIndex = 1;
            this.label1.Text = "BoatClubApp";
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabControl1.Location = new System.Drawing.Point(0, 0);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(763, 492);
            this.tabControl1.TabIndex = 0;
            // 
            // ButtonView
            // 
            this.ButtonView.Location = new System.Drawing.Point(30, 404);
            this.ButtonView.Name = "ButtonView";
            this.ButtonView.Size = new System.Drawing.Size(75, 23);
            this.ButtonView.TabIndex = 11;
            this.ButtonView.Text = "View";
            this.ButtonView.UseVisualStyleBackColor = true;
            // 
            // buttonAddBoat
            // 
            this.buttonAddBoat.Location = new System.Drawing.Point(133, 404);
            this.buttonAddBoat.Name = "buttonAddBoat";
            this.buttonAddBoat.Size = new System.Drawing.Size(75, 23);
            this.buttonAddBoat.TabIndex = 12;
            this.buttonAddBoat.Text = "Add Boat";
            this.buttonAddBoat.UseVisualStyleBackColor = true;
            // 
            // buttonDelete
            // 
            this.buttonDelete.Location = new System.Drawing.Point(230, 404);
            this.buttonDelete.Name = "buttonDelete";
            this.buttonDelete.Size = new System.Drawing.Size(75, 23);
            this.buttonDelete.TabIndex = 13;
            this.buttonDelete.Text = "Delete";
            this.buttonDelete.UseVisualStyleBackColor = true;
            // 
            // listBoxMemberList
            // 
            this.listBoxMemberList.FormattingEnabled = true;
            this.listBoxMemberList.Location = new System.Drawing.Point(29, 264);
            this.listBoxMemberList.MultiColumn = true;
            this.listBoxMemberList.Name = "listBoxMemberList";
            this.listBoxMemberList.Size = new System.Drawing.Size(692, 134);
            this.listBoxMemberList.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.ClientSize = new System.Drawing.Size(763, 492);
            this.Controls.Add(this.tabControl1);
            this.Name = "Form1";
            this.Text = "BoatClubApp";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.tabControl1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioButtonVerbose;
        private System.Windows.Forms.RadioButton radioButtonCompact;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonSave;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBoxPersonalNo;
        private System.Windows.Forms.TextBox textBoxName;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button buttonDelete;
        private System.Windows.Forms.Button buttonAddBoat;
        private System.Windows.Forms.Button ButtonView;
        private System.Windows.Forms.ListBox listBoxMemberList;
    }
}

