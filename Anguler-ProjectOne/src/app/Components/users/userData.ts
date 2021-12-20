    export class UsersData{
    private name: string;
    private password: string;
    // private email: string;
    // private type: number;
    // private requestId: number;
    // private address: string;
    // private contact: string;





    constructor (name: string, password: string ){

      this.name = name;
      this.password = password;
      // this.email = email;
      // this.type = type;
      // this.requestId = requestId;
      // this.address = address;
      // this.contact = contact;
    }

    getName(): string{
    return this.name
    }

    getPassword(): string{
    return this.password;
    }

    // getEmail(): string{
    // return this.email;
    // }

    // getType(): number{
    // return this.type;
    // }

    // getRequestId(): number{
    // return this.requestId;
    // }

    // getAddress(): string{
    // return this.address;
    // }

    // getContact(): string{
    // return this.contact;
    // }





    }


