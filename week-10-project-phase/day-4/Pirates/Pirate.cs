using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pirates
{
    class Pirate
    {
        private int levelOfIntoxication;
        public int LevelOfIntoxication { get => levelOfIntoxication; set => levelOfIntoxication = value; }
        

        private bool isDead;
        public bool IsDead { get => isDead; set => isDead = value; }
        

        private bool isPassedOut;
        public bool IsPassedOut { get => isPassedOut; set => isPassedOut = value; }

        private Parrot parrot;
        internal Parrot Parrot { get => parrot; set => parrot = value; }

        public Pirate()
        {
            this.LevelOfIntoxication = 0;
            this.IsDead = false;
            this.IsPassedOut = false;
        }

        public void DrinkSomeRum()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }
            this.LevelOfIntoxication++;
        }

        public void HowsItGoingMate()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }

            if(LevelOfIntoxication <= 4)
            {
                Console.WriteLine("Pour me anudder!");
                this.DrinkSomeRum();
            } else
            {
                Console.WriteLine("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                this.IsPassedOut = true;
            }
        }

        public void Sleep()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }
            this.LevelOfIntoxication = 0;
            this.IsPassedOut = false;
        }

        public void Die()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }
            this.IsDead = true;
        }

        public void Brawl(Pirate pirate)
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }

            if (pirate.IsDead)
            {
                Console.WriteLine("The other pirate is dead.");
                return;
            }

            switch (new Random().Next(1, 4))
            {
                case 1:
                    this.Die();
                    break;
                case 2:
                    pirate.Die();
                    break;
                case 3:
                    this.IsPassedOut = true;
                    pirate.IsPassedOut = true;
                    Console.WriteLine("They are both dead.");
                    break;
            }
        }

        public void AddParrot(string name)
        {
            Parrot = new Parrot(name);
        }
    }
}
