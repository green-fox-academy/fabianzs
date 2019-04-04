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
        public int LevelOfIntoxication { get; set; }

        private bool isDead;
        public bool IsDead { get; set; }

        private bool isPassedOut;
        public bool IsPassedOut { get; set; }

        private Parrot parrot;
        public Parrot Parrot { get; set; }

        public Pirate()
        {
            this.levelOfIntoxication = 0;
            this.isDead = false;
            this.isPassedOut = false;
        }

        public void DrinkSomeRum()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }
            this.levelOfIntoxication++;
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
                    break;
            }
        }

        public void AddParrot(string name)
        {
            Parrot = new Parrot(name);
        }
    }
}
