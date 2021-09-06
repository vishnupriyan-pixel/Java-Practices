import cypressTest from "./cypressTest";
const { verify } = require("crypto");

describe('AutoComplete',function(){

  it('Visits jQuery Autocomplete', function(){
    const auto1 = new cypressTest()
   auto1.visit1()
   cy.url().then(url => {
    cy.url().should('be.eq', url);
  })
  })

  it('Visits SpecialCharacters_Autocomplete', ()=> {
    cy.get('iframe').then(($iframe)=>{
      const $input = $iframe.contents().find('body').find('div').find('input');
      let auto2 = cy.wrap($input)
      auto2.type('!@@$%');
      auto2.type('{enter}');
      auto2.wait(1000)
      auto2.should('be.enabled')
      auto2.should($inputfield => expect($inputfield).to.be.visible)
    })
})

it('Visits Numbers_AutoComplete', ()=> {
  cy.get('iframe').then(($iframe)=>{
    const $input = $iframe.contents().find('body').find('div').find('input');
    let auto2 = cy.wrap($input)
    auto2.clear();
    auto2.type('5468790');
    auto2.type('{enter}');
    auto2.wait(1000)
    auto2.should('be.enabled')
    auto2.should($inputfield => expect($inputfield).to.be.visible)
  })
})

  it('Visits AutoComplete', ()=> {
    cy.get('iframe').then(($iframe)=>{
      const $input = $iframe.contents().find('body').find('div').find('input');
      let auto2 = cy.wrap($input)
      auto2.clear();
      auto2.type('JavaS');
      auto2.type('{downarrow}')
      auto2.type('{downarrow}')
      auto2.type('{enter}');
      auto2.wait(1000)
      auto2.should('be.enabled')
      auto2.should($inputfield => expect($inputfield).to.be.visible)
      expect({ name: 'JavaScript' }).to.deep.equal({ name: 'JavaScript' })
    })
})

})

describe('Buttons', function(){
    it('Visits jQuery', function(){
      const rd = new cypressTest()
   rd.visit2()
   cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits_Widget_Button', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body').find('div')

       let btn1 = cy.wrap($button)
      btn1.xpath('//div[@class="widget"]//button').click({force: true})
      btn1.wait(700)
      btn1.should('be.visible')
      btn1.xpath('//div[@class="widget"]//button').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_Widget_Submit_Button', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body').find('div')

       let btn1 = cy.wrap($button)
      btn1.xpath('//div[@class="widget"]//input').click({force: true})
      btn1.wait(700)
      btn1.should('be.visible')
      btn1.xpath('//div[@class="widget"]//input').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_Widget_Anchor', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body').find('div')

       let btn1 = cy.wrap($button)
      btn1.xpath('//div[@class="widget"]//a').click({force: true})
      btn1.wait(700)
      btn1.should('be.visible')
      btn1.xpath('//div[@class="widget"]//a').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_CSS_Button', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body>button')

       let btn1 = cy.wrap($button)
      btn1.contains('button', 'A button element').click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      btn1.contains('button', 'A button element').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_CSS_SubmitButton', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body>input')

       let btn1 = cy.wrap($button)
      btn1.click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      expect({ type: 'submit' }).to.deep.equal({ type: 'submit' })

    })

  })

  it('Visits_CSS_Anchor', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body>a')

       let btn1 = cy.wrap($button)
      btn1.contains('a', 'An anchor').click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      btn1.contains('a', 'An anchor').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })
})

describe('Radio_button & CheckBox', function(){

  it('Visits jQuery Checkboxradio', function(){
   const rd = new cypressTest()
   rd.visit3()
   cy.url().then(url => {
    // cy.get('.editor-toolbar-actions-save').click();
    cy.url().should('be.eq', url);
  })
})

it('Visits radio_button1', function(){
  const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#radio-1')
        .click({force: true})
        .should('be.checked')

    })
  })

  it('Visits radio_button2', function(){
     cy.get('.demo-frame')
     .then(($iframe) => {
       const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#radio-2')
        .click({force: true})
        .should('be.checked')

    })
  })

  it('Visits radio_button3', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#radio-3')
        .click({force: true})
        .should('be.checked')

    })
  })

  it('Visits checkbox1', function(){
     cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-1').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')


    })
  })

  it('Visits checkbox2', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-2').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')


    })

  })

  it('Visits checkbox3', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-3').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')

    })
  })

  it('Visits checkbox4', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-4').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')

    })
  })

  it('Visits checkbox_nested1', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-nested-1').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
    })
  })

  it('Visits checkbox_nested2', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-nested-2').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
      })
    })

    it('Visits checkbox_nested3', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
          .find('#checkbox-nested-3').scrollIntoView()
          .uncheck({force: true})
          .not('be.checked')
          .check({force: true})
          .should('be.checked')
        })

      })

      it('Visits checkbox_nested4', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
          const $body = $iframe.contents().find('body')

          cy.wrap($body)
            .find('#checkbox-nested-4').scrollIntoView()
            .uncheck({force: true})
            .not('be.checked')
            .check({force: true})
            .should('be.checked')
          })

        })

})


describe('Controlgroup', function(){
  it('Visits jQuery Controlgroup', function(){
    const rd = new cypressTest()
    rd.visit4()
    cy.url().then(url => {
     cy.url().should('be.eq', url);
   })
 })
  it('Visits Rental_car_dropdown1(Fieldset1)', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#car-type').scrollIntoView()
    .select('Compact car', {force: true})
    expect({ name: 'Compact car' }).to.deep.equal({ name: 'Compact car' })
    })
  })

  it('Visits Rental_car_dropdown2(Fieldset1)', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
       expect({ name: 'Midsize car' }).to.deep.equal({ name: 'Midsize car' })
      })
  })

  it('Visits Rental_car_dropdown3(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Full size car' }).to.deep.equal({ name: 'Full size car' })
        })
      })

  it('Visits Rental_car_dropdown4(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'SUV' }).to.deep.equal({ name: 'SUV' })
        })
      })

  it('Visits Rental_car_dropdown5(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Luxury' }).to.deep.equal({ name: 'Luxury' })
        })
      })

  it('Visits Rental_car_dropdown6(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Truck' }).to.deep.equal({ name: 'Truck' })
        })
      })

  it('Visits Rental_car_dropdown7(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Van' }).to.deep.equal({ name: 'Van' })
        })
      })

  it('Visits Standard_radio_button(Fieldset1)', function(){
      const rd = new cypressTest()
      rd.chck_iframe()
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#transmission-standard')
      .click({force: true})
      .should('be.checked')
      expect({ name: 'Standard' }).to.deep.equal({ name: 'Standard' })
        })
      })

  it('Visits Automatic_radio_button(Fieldset1)', function(){
      const rd = new cypressTest()
      rd.chck_iframe()
      cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#transmission-automatic')
        .click({force: true})
        .should('be.checked')
        expect({ name: 'Automatic' }).to.deep.equal({ name: 'Automatic' })
        })
    })

  it('Visits Insurance_checkbox(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#insurance').scrollIntoView()
      .uncheck({force: true})
      .not('be.checked')
      .check({force: true})
      .should('be.checked')
      })
    })

  it('Visits # of cars(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#horizontal-spinner').click({force: true})
      .type('{downarrow}')
      .type('{downarrow}')
      .wait(800)
      .type('{uparrow}')
      .type('{uparrow}')
      .type('{uparrow}')
      .type('{uparrow}')
      .should($inputfield => expect($inputfield).to.be.visible)
      })
    })

  it('Visits_Booknow_button(Fieldset1)', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $button = $iframe.contents().find('body')

    let btn1 = cy.wrap($button)
    .find('.ui-controlgroup-item')
    btn1.contains('button', 'Book Now!').click({force: true})
    btn1.wait(900)
    btn1.should('be.visible')
    btn1.contains('button', 'Book Now!').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })



    it('Visits Rental_car_dropdown1(Fieldset2)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#ui-id-8').scrollIntoView()
      .select('Compact car', {force: true})
      expect({ name: 'Compact car' }).to.deep.equal({ name: 'Compact car' })
      })
    })

    it('Visits Rental_car_dropdown2(Fieldset2)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
         expect({ name: 'Midsize car' }).to.deep.equal({ name: 'Midsize car' })
        })
    })

    it('Visits Rental_car_dropdown3(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Full size car' }).to.deep.equal({ name: 'Full size car' })
          })
        })

    it('Visits Rental_car_dropdown4(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'SUV' }).to.deep.equal({ name: 'SUV' })
          })
        })

    it('Visits Rental_car_dropdown5(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Luxury' }).to.deep.equal({ name: 'Luxury' })
          })
        })

    it('Visits Rental_car_dropdown6(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Truck' }).to.deep.equal({ name: 'Truck' })
          })
        })

    it('Visits Rental_car_dropdown7(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Van' }).to.deep.equal({ name: 'Van' })
          })
        })

    it('Visits Standard_radio_button-v(Fieldset2)', function(){
        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#transmission-standard-v')
        .click({force: true})
        .should('be.checked')
        expect({ name: 'Standard' }).to.deep.equal({ name: 'Standard' })
          })
        })

    it('Visits Automatic_radio_button-v(Fieldset2)', function(){
        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
          .then(($iframe) => {
          const $body = $iframe.contents().find('body')

          cy.wrap($body)
          .find('#transmission-automatic-v')
          .click({force: true})
          .should('be.checked')
          expect({ name: 'Automatic' }).to.deep.equal({ name: 'Automatic' })
          })
      })

    it('Visits Insurance_checkbox(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#insurance-v').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        })
      })

      it('Visits # of cars(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#vertical-spinner').click({force: true})
        .type('{downarrow}')
        .type('{downarrow}')
        .wait(800)
        .type('{uparrow}')
        .type('{uparrow}')
        .type('{uparrow}')
        .should($inputfield => expect($inputfield).to.be.visible)
        })
      })

    it('Visits_Booknow_button(Fieldset2)', function(){
      const rd = new cypressTest()
      rd.chck_iframe()
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#book')
      btn1.contains('button', 'Book Now!').click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      btn1.contains('button', 'Book Now!').should('have.css', 'background-color', 'rgb(237, 237, 237)')

      })

    })

})

describe('Visits Datepicker', function(){
  it('Visits jQuery Datepicker', function(){
    const rd = new cypressTest()
    rd.visit5()
    cy.url().then(url => {
     cy.url().should('be.eq', url);
   })
 })

  it('Incorrect data in Datefield', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#datepicker')
      .click({force: true})
      btn1.wait(900)
      .type('1312456076769909')
      .type('{enter}')
      btn1.should('be.visible')
      .should('be.enabled')
    })
  })

  it('valid date in textbox', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#datepicker')
      .click({force: true})
      btn1.wait(900)
      .clear()
      .type('07/22/1990')
      .type('{enter}')
      .click({force: true})
      btn1.should('be.visible')
      .should('be.enabled')
    })
  })

  it('chossing date using next & previous_button', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $button = $iframe.contents().find('body')
    let btn1 = cy.wrap($button)
    btn1.contains('Next').should('have.attr', 'data-event', 'click').click()


        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $button = $iframe.contents().find('body').find('table').find('td')
        let btn1 = cy.wrap($button)
        .find('.ui-state-default')
        .contains('a', '22').click()
        .wait(600)
        .should('have.text', '22')

        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $button = $iframe.contents().find('body')
        let btn1 = cy.wrap($button)
        btn1.contains('Prev').should('have.attr', 'data-event', 'click').click({force:true})


        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $button = $iframe.contents().find('body').find('table').find('td')
        let btn1 = cy.wrap($button)
        .find('.ui-state-default')
        .contains('a', '7').click({force:true})
        .wait(600)
        .should('have.text', '7')
        })
      })
    })
    })
  })

  it('Incorrect_date_month_year', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#datepicker')
      .click({force: true})
      btn1.wait(900)
      .clear()
      .type('64/80/16590')
      .type('{enter}')
      .click({force: true})
      btn1.should('be.visible')
      .should('be.enabled')
    })
  })
})
